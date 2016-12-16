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

    public ArrayList<String> getGames(){
        System.out.println("Vou buscar os resultados ao webserver.");
        ArrayList<String> results;
        results = (ArrayList<String>) new GameOntologyServerService().getPort(GameOntologyServer.class).listClassByProperty("Game" , "hasGameName", true);
        System.out.println("Já os tenho");
        return results;
    }

    public List<String> getGame(String gameid, boolean isID){
        System.out.println("Vou buscar os resultados ao webserver.");
        List<String> results;
        results =  new GameOntologyServerService().getPort(GameOntologyServer.class).getGameInfo(gameid, isID);
        System.out.println("Já os tenho");
        return results;
    }

}
