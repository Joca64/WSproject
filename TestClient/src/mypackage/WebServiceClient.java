package mypackage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by itspm on 15/12/2016.
 */
public class WebServiceClient {

    private String deOnde;

    public void setDeOnde(String nome){
        this.deOnde = nome;
    }

    public String chamarWebservice(){
        String resposta = new GameOntologyServerService().getPort(GameOntologyServer.class).sayHelloWorldFrom(deOnde);
        System.out.println("recebi "+resposta);
        return resposta;
    }

    public static void main(String[] args) {
        System.out.println(new GameOntologyServerService().getPort(GameOntologyServer.class).sayHelloWorldFrom("casa do caralho"));
    }

    public ArrayList<String> getGames(int limit, int page){
        System.out.println("Vou buscar os resultados de jogos ao webserver.");
        ArrayList<String> results;
        results = (ArrayList<String>) new GameOntologyServerService().getPort(GameOntologyServer.class).listClassByProperty("Game" , "hasGameName", true, limit, page);
        System.out.println("Já os tenho");
        return results;
    }

    public List<String> getGame(String gameid, boolean isID){
        System.out.println("Vou buscar os resultados de jogo ao webserver.");
        List<String> results;
        results =  new GameOntologyServerService().getPort(GameOntologyServer.class).getGameInfo(gameid, isID);
        System.out.println("Já os tenho");
        System.out.println(results);
        return results;
    }

    public List<String> getFranchise(String franchiseid, boolean isID){
        System.out.println("Vou buscar os resultados de franchise ao webserver.");
        List<String> results;
        results =  new GameOntologyServerService().getPort(GameOntologyServer.class).getFranchiseInfo(franchiseid, isID);
        System.out.println("Já os tenho");
        System.out.println(results);
        return results;
    }

    public List<String> getCompany(String companyid, boolean isID, String type){
        System.out.println("Vou buscar os resultados de company ao webserver.");
        List<String> results;
        results =  new GameOntologyServerService().getPort(GameOntologyServer.class).getCompanyInfo(companyid, isID, type);
        System.out.println("Já os tenho");
        return results;
    }

    public List<String> getGenre(String name){
        System.out.println("Vou buscar os jogos de genre ao webserver.");
        List<String> results;
        results =  new GameOntologyServerService().getPort(GameOntologyServer.class).listGamesByType(name, "Genre");
        System.out.println("Já os tenho");
        return results;
    }

    public List<String> getTheme(String name){
        System.out.println("Vou buscar os jogos de theme ao webserver.");
        List<String> results;
        results =  new GameOntologyServerService().getPort(GameOntologyServer.class).listGamesByType(name, "Theme");
        System.out.println("Já os tenho");
        return results;
    }
}
