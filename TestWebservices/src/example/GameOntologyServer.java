package example;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by itspm on 15/12/2016.
 */
@WebService()
public class GameOntologyServer {

  private static final String sparqlPrefix = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
          "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
          "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
          "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
          "PREFIX games: <http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#>\n" +
          "\n";

  private static OntModel ontologyModel;
  private static Model model;


  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }

  @WebMethod
  public String sayHelloWorldFromNoob() {
    String result = "Hello, world, from pica";
    System.out.println(result);
    return result;
  }

  @WebMethod
  public String[] getCompanyInfo(String company, boolean isID, String type)
  {
    String[] results = new String[6];
    String sparqlQuery;

    sparqlQuery = sparqlPrefix +
            "SELECT ?name ?id ?description ?country ?website (group_concat( distinct ?game;separator=\"+\") as ?games)\n" +
            "\tWHERE {\n" +
            "\t\t?Company a games:"+ type +" .\n";

    if(isID){
      sparqlQuery = sparqlQuery +
              "\t\t?Company games:hasCompanyID "+ company +" .\n" +
              "\t\t?Company games:hasCompanyName ?name .\n";
    }else{
      sparqlQuery = sparqlQuery +
              "\t\t?Company games:hasCompanyName \""+ company +"\" .\n" +
              "\t\t?Company games:hasCompanyID ?id .\n";
    }

    sparqlQuery = sparqlQuery +
            "\t\t?Company games:hasCompanyDescription ?description .\n" +
            "\t\t?Company games:hasCompanyCountry ?country .\n" +
            "\t\t?Company games:hasCompanyWebsite ?website .\n";

    if(type.equals("Publisher")){
      sparqlQuery = sparqlQuery +
              "\t\t?Company games:hasPublished ?gameURI .\n";
    }else{
      sparqlQuery = sparqlQuery +
              "\t\t?Company games:hasDeveloped ?gameURI .\n";
    }

    sparqlQuery = sparqlQuery +
            "\t\t?gameURI games:hasGameName ?game .\n" +
            "\t}" +
            "GROUP BY ?name ?id ?description ?country ?website";

    try{
      Query query = QueryFactory.create(sparqlQuery);
      QueryExecution qe = QueryExecutionFactory.create(query, model);
      ResultSet answer = qe.execSelect();

      while (answer.hasNext()) {
        QuerySolution qs = answer.nextSolution();
        System.out.println("Result: " + qs.toString());

        if(isID){
          results[0] = (qs.get("?name").toString());
          results[1] = company;
        }
        else{
          results[0] = company;
          String[] parts = (qs.get("?id").toString()).split("\\^\\^");
          results[1] = parts[0];
        }

        results[2] = (qs.get("?description").toString());

        results[3] = (qs.get("?country").toString());

        String[] parts = (qs.get("?website").toString()).split("\\^\\^");
        try {
          results[4] = java.net.URLDecoder.decode(parts[0],"UTF-8");
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }

        if(qs.get("?games") == null)
          results[5] = ("N/A");
        else
          results[5] = qs.get("?games").toString();
      }

      qe.close();
    }catch (Exception e){
      System.out.println(e);
      return null;
    }

    return results;
  }

  @WebMethod
  public ArrayList<String> getGamesFromPlatform(String platform)
  {
    ArrayList<String> results = new ArrayList<String>();
    String sparqlQuery;

    sparqlQuery = sparqlPrefix +
            "SELECT ?Game\n" +
            "\tWHERE {\n" +
            "\t\t?Platform a games:Platform .\n" +
            "\t\t?Platform games:hasPlatformID "+platform+" .\n" +
            "\t\t?Game games:developedForPlatform ?Platform .\n" +
            "\t}"
    ;

    Query query = QueryFactory.create(sparqlQuery);
    QueryExecution qe = QueryExecutionFactory.create(query, model);
    ResultSet answer = qe.execSelect();

    while (answer.hasNext()) {
      QuerySolution qs = answer.nextSolution();
      RDFNode temp = qs.get("Game");
      results.add(temp.asNode().getLocalName());
    }

    qe.close();

    return results;
  }

  @WebMethod
  public ArrayList<String> getGamesFromFranchise(String franchise)
  {
    ArrayList<String> results = new ArrayList<String>();
    String sparqlQuery;

    sparqlQuery = sparqlPrefix +
            "SELECT ?Game\n" +
            "\tWHERE {\n" +
            "\t\t?Franchise a games:Franchise .\n" +
            "\t\t?Franchise games:hasFranchiseID "+franchise+" .\n" +
            "\t\t?Game games:belongsToFranchise ?Franchise .\n" +
            "\t}"
    ;

    Query query = QueryFactory.create(sparqlQuery);
    QueryExecution qe = QueryExecutionFactory.create(query, model);
    ResultSet answer = qe.execSelect();

    while (answer.hasNext()) {
      QuerySolution qs = answer.nextSolution();
      RDFNode temp = qs.get("Game");
      results.add(temp.asNode().getLocalName());
    }

    qe.close();

    return results;
  }

  @WebMethod
  public ArrayList<String> listClassByProperty(String className, String property, boolean asc, int limit, int page)
  {
    ArrayList<String> results = new ArrayList<String>();
    String sparqlQuery;

    sparqlQuery = sparqlPrefix +
            "SELECT ?"+className+" ?name\n" +
            "\tWHERE {\n" +
            "\t\t?"+className+" a games:"+className+" .\n" +
            "\t\t?"+className+" games:"+property+" ?name .\n" +
            "\t}"
    ;

    if(asc)
      sparqlQuery = sparqlQuery + "\tORDER BY ASC(?name)\n";
    else
      sparqlQuery = sparqlQuery + "\tORDER BY DESC(?name)\n";

    if(limit!=0){
      sparqlQuery = sparqlQuery + "\tOFFSET " + (page*limit) + "\n";
      sparqlQuery = sparqlQuery + "\tLIMIT " + limit;
    }

    Query query = QueryFactory.create(sparqlQuery);
    QueryExecution qe = QueryExecutionFactory.create(query, model);
    ResultSet answer = qe.execSelect();

    while (answer.hasNext()) {
      QuerySolution qs = answer.nextSolution();
      results.add(qs.get("?name").toString());
    }

    qe.close();
    return results;
  }

  @WebMethod
  public ArrayList<String> listGamesByType(String name, String type){
    ArrayList<String> results = new ArrayList<String>();
    String sparqlQuery;

    sparqlQuery = sparqlPrefix +
            "SELECT ?Game ?name\n" +
            "\tWHERE {\n" +
            "\t\t?Game a games:Game .\n" +
            "\t\t?Game games:"+type+" \"" + name + "\" .\n" +
            "\t\t?Game games:hasGameName ?name .\n" +
            "\t}"
    ;

    Query query = QueryFactory.create(sparqlQuery);
    QueryExecution qe = QueryExecutionFactory.create(query, model);
    ResultSet answer = qe.execSelect();

    while (answer.hasNext()) {
      QuerySolution qs = answer.nextSolution();
      results.add(qs.get("?name").toString());
    }

    qe.close();
    return results;
  }

  @WebMethod
  public String[] getGameInfo(String game, boolean isID)
  {
    String[] results = new String[10];
    String sparqlQuery;

    sparqlQuery = sparqlPrefix +
            "SELECT\t ?name ?id ?description ?image (group_concat( distinct ?genre;separator=\"+\") as ?genres) (group_concat( distinct ?theme;separator=\"+\") as ?themes) (group_concat( distinct ?publisher;separator=\"+\") as ?publishers) (group_concat( distinct ?developer;separator=\"+\") as ?developers) (group_concat( distinct ?platform;separator=\"+\") as ?platforms) (group_concat( distinct ?franchise;separator=\"+\") as ?franchises)\n" +
            "\tWHERE {\n" +
            "\t\t?Game a games:Game .\n";

    if(isID)
    {
      sparqlQuery = sparqlQuery +
              "\t\t?Game games:hasGameName ?name .\n" +
              "\t\t?Game games:hasGameID " + game + " .\n";
    }
    else
    {
      sparqlQuery = sparqlQuery +
              "\t\t?Game games:hasGameName \"" + game +"\" .\n" +
              "\t\t?Game games:hasGameID ?id .\n";
    }

    sparqlQuery = sparqlQuery +
            "\t\t?Game games:hasGameDescription ?description .\n" +
            "\t\t?Game games:hasGameImage ?image .\n" +
            "\t\tOPTIONAL { ?Game games:hasGameGenre ?genre } .\n" +
            "\t\tOPTIONAL { ?Game games:hasGameTheme ?theme } .\n" +
            "\t\tOPTIONAL { ?Game games:isPublishedBy ?publisherURI } .\n" +
            "\t\tOPTIONAL { ?publisherURI games:hasCompanyName ?publisher } .\n" +
            "\t\tOPTIONAL { ?Game games:isDevelopedBy ?developerURI } .\n" +
            "\t\tOPTIONAL { ?developerURI games:hasCompanyName ?developer } .\n" +
            "\t\tOPTIONAL { ?Game games:developedForPlatform ?platformURI } .\n" +
            "\t\tOPTIONAL { ?platformURI games:hasPlatformName ?platform } .\n" +
            "\t\tOPTIONAL { ?Game games:belongsToFranchise ?franchiseURI } .\n" +
            "\t\tOPTIONAL { ?franchiseURI games:hasFranchiseName ?franchise } .\n" +
            "\t}" +
            "GROUP BY ?name ?id ?description ?image";

    System.out.println(sparqlQuery);

    try{
      Query query = QueryFactory.create(sparqlQuery);
      QueryExecution qe = QueryExecutionFactory.create(query, model);
      ResultSet answer = qe.execSelect();

      while (answer.hasNext()) {
        QuerySolution qs = answer.nextSolution();
        System.out.println("Result: " + qs.toString());

        if(isID){
          results[0] = (qs.get("?name").toString());
          results[1] = game;
        }
        else{
          results[0] = game;
          String[] parts = (qs.get("?id").toString()).split("\\^\\^");
          results[1] = parts[0];
        }

        results[2] = (qs.get("?description").toString());

        String[] parts = (qs.get("?image").toString()).split("\\^\\^");
        try {
          results[3] = java.net.URLDecoder.decode(parts[0],"UTF-8");
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }

        if(qs.get("?genres") == null || qs.get("?genres").toString().length() > 250)
          results[4] = ("N/A");
        else
          results[4] = qs.get("?genres").toString();

        if(qs.get("?themes") == null || qs.get("?themes").toString().length() > 250)
          results[5] = ("N/A");
        else
          results[5] = (qs.get("?themes").toString());

        if(qs.get("?developers") == null || qs.get("?developers").toString().length() > 250)
          results[6] = ("N/A");
        else
          results[6] = (qs.get("?developers").toString());

        if(qs.get("?publishers") == null || qs.get("?publishers").toString().length() > 250)
          results[7] = ("N/A");
        else
          results[7] = (qs.get("?publishers").toString());

        if(qs.get("?platforms") == null || qs.get("?platforms").toString().length() > 250)
          results[8] = ("N/A");
        else
          results[8] = (qs.get("?platforms").toString());

        if(qs.get("?franchises") == null || qs.get("?franchises").toString().length() > 250)
          results[9] = ("N/A");
        else
          results[9] = (qs.get("?franchises").toString());
      }
      qe.close();
    }catch (Exception e){
      System.out.println(e);
      return null;
    }

    return results;
  }

  public static void main(String[] argv) {
    Object implementor = new GameOntologyServer();
    String address = "http://localhost:9000/GameOntologyServer";
    Endpoint.publish(address, implementor);

    readOntology();

    System.out.println("Webserver running.");
  }

  public static void readOntology(){
    ontologyModel = ModelFactory.createOntologyModel();
    ontologyModel.read("resources/ontology_generated_min.owl", "RDF/XML");
    model = ontologyModel.getBaseModel();

    Reasoner reasoner = ReasonerRegistry.getRDFSReasoner();
    InfModel inf = ModelFactory.createInfModel(reasoner, model);
    ValidityReport validity = inf.validate();
    if (validity.isValid()) {
      System.out.println("OK");
    } else {
      System.out.println("Conflicts");
      for (Iterator i = validity.getReports(); i.hasNext(); ) {
        System.out.println(" - " + i.next());
      }
    }
  }

}
