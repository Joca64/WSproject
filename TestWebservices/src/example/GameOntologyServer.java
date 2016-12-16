package example;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;

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
  public ArrayList<String> listClassByProperty(String className, String property, boolean asc)
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

    Query query = QueryFactory.create(sparqlQuery);
    QueryExecution qe = QueryExecutionFactory.create(query, model);
    ResultSet answer = qe.execSelect();

    while (answer.hasNext()) {
      QuerySolution qs = answer.nextSolution();
      results.add(qs.get("?name").toString());
    }

    qe.close();
    System.out.println("Enviei os resultados");
    return results;
  }

  @WebMethod
  public String[] getGameInfo(String gameID, boolean isID)
  {
    String[] results = new String[9];
    String sparqlQuery;

    if(isID)
    {
      sparqlQuery = sparqlPrefix +
              "SELECT ?Game ?name ?description ?image ?genre ?theme ?developer ?publisher ?platform ?franchise\n" +
              "\tWHERE {\n" +
              "\t\t?Game a games:Game .\n" +
              "\t\t?Game games:hasGameID " + gameID + " .\n" +
              "\t\t?Game games:hasGameName ?name .\n";
    }
    else
    {
      sparqlQuery = sparqlPrefix +
              "SELECT ?Game ?id ?description ?image ?genre ?theme ?developer ?publisher ?platform ?franchise\n" +
              "\tWHERE {\n" +
              "\t\t?Game a games:Game .\n" +
              "\t\t?Game games:hasGameID ?id .\n" +
              "\t\t?Game games:hasGameName \"" + gameID +"\" .\n";
    }

    sparqlQuery = sparqlQuery +
            "\t\t?Game games:hasGameName ?name .\n" +
            "\t\t?Game games:hasGameDescription ?description .\n" +
            "\t\t?Game games:hasGameImage ?image .\n" +
            "\t\tOPTIONAL { ?Game games:hasGameGenre ?genre } .\n" +
            "\t\tOPTIONAL { ?Game games:hasGameTheme ?theme } .\n" +
            "\t\tOPTIONAL { ?Game games:isDevelopedBy ?developer } .\n" +
            "\t\tOPTIONAL { ?Game games:isPublishedBy ?publisher } .\n" +
            "\t\tOPTIONAL { ?Game games:developedForPlatform ?platform }.\n" +
            "\t\tOPTIONAL { ?Game games:belongsToFranchise ?franchise } .\n" +
            "\t}"
    ;

    Query query = QueryFactory.create(sparqlQuery);
    QueryExecution qe = QueryExecutionFactory.create(query, model);
    ResultSet answer = qe.execSelect();

    while (answer.hasNext()) {
      QuerySolution qs = answer.nextSolution();
      if(isID)
        results[0] = (qs.get("?name").toString());
      else
        results[0] = (qs.get("?id").toString());
      results[1] = (qs.get("?description").toString());
      results[2] = (qs.get("?image").toString());
      if(qs.get("?genre") == null)
        results[3] = ("N/A");
      else
        results[3] = (qs.get("?genre").toString());

      if(qs.get("?theme") == null)
        results[4] = ("N/A");
      else
        results[4] = (qs.get("?theme").toString());

      if(qs.get("?developer") == null)
        results[5] = ("N/A");
      else
        results[5] = (qs.get("?developer").toString());

      if(qs.get("?publisher") == null)
        results[6] = ("N/A");
      else
        results[6] = (qs.get("?publisher").toString());

      if(qs.get("?platform") == null)
        results[7] = ("N/A");
      else
        results[7] = (qs.get("?platform").toString());

      if(qs.get("?franchise") == null)
        results[8] = ("N/A");
      else
        results[8] = (qs.get("?franchise").toString());
    }

    qe.close();

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
    ontologyModel.read("resources/ontology_generated.owl", "RDF/XML");
    model = ontologyModel.getBaseModel();
  }

}
