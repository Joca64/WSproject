import com.yoshtec.owl.marshall.Marshaller;
import dataTypes.*;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFReader;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.util.FileManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class OntologyPopulator
{
    //private OntModel ontologyModel;
    //private String namespace;

    ArrayList<Game> games;
    ArrayList<Franchise> franchises;
    ArrayList<Developer> developers;
    ArrayList<Publisher> publishers;
    ArrayList<Manufacturer> manufacturers;
    ArrayList<Platform> platforms;


    public OntologyPopulator(String filepath, String type){
        //ontologyModel = ModelFactory.createOntologyModel();
        //ontologyModel.read(filepath, type);
        //namespace = ontologyModel.getNsPrefixURI("");
        //System.out.println(namespace);

        this.games = new ArrayList<Game>();
        this.franchises = new ArrayList<Franchise>();
        this.developers = new ArrayList<Developer>();
        this.publishers = new ArrayList<Publisher>();
        this.manufacturers = new ArrayList<Manufacturer>();
        this.platforms = new ArrayList<Platform>();

        //popular franchises, developers, publishers, platforms sem array de jogos
        populateFranchises(false);
        populateDevelopers(false);
        populatePublishers(false);
        populatePlatformsManufacturers(false);
        //popular jogos
        populateGames();
        //popular array de jogos das franchises, developers, publishers, platforms
        populateFranchises(true);
        populateDevelopers(true);
        populatePublishers(true);
        populatePlatformsManufacturers(true);

        //update valores
        for(Developer d: developers){
            d.setTotalGamesDeveloped();
            //System.out.print(d.getTotalGamesDeveloped() + ":");
        }
        //System.out.println("");
        for(Manufacturer m: manufacturers){
            m.setTotalPlatformsManufactured();
            //System.out.print(m.getTotalPlatformsManufactured() + ":");
        }
        //System.out.println("");
        for(Publisher p: publishers){
            p.setTotalGamesPublished();
            //System.out.print(p.getTotalGamesPublished() + ":");
        }

        printGames();
    }

    public void printGames(){
        /*System.out.println("Franchises");
        for(Franchise f: franchises){
            System.out.print(f.toString() + ":");
        }*/
        int count=1;
        System.out.println("[Counter][ID]name:genres:themes:franchises:publishers:developers");
        for(Game g: games){
            System.out.print("[" + count + "]");
            System.out.println(g.toString());
            count++;
        }
    }

    public void populateFranchises(boolean populateGameList){
        JSONParser parser = new JSONParser();
        JSONArray array = null;
        try {
            array = (JSONArray) parser.parse(readJson("resources/franchises.json"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(Object object: array) {
            populateFranchise(object, populateGameList);
        }
    }

    public void populateFranchise(Object object, boolean populateGameList){

        JSONObject franchise = (JSONObject) object;
        int id = Integer.parseInt(String.valueOf(franchise.get("id")));

        if(populateGameList){
            Franchise f_temp = findFranchiseID(id);
            //adicionar lista de jogos, revendo se o jogo existe na lista de games
            JSONArray games = (JSONArray) franchise.get("games");
            ArrayList<Game> new_games = new ArrayList<Game>();
            for(Object subObject: games) {
                JSONObject game = (JSONObject) subObject;
                final int g_id = Integer.parseInt(String.valueOf(game.get("id")));
                Game g_temp = findGameID(g_id);
                //caso o jogo nao exista em games
                if(g_temp==null){
                    String g_name = (String) game.get("name");
                    //descricao do jogo
                    String g_description = (String) game.get("site_detail_url");
                    g_temp = new Game(g_id, g_name, g_description, "");
                    g_temp.addFranchise(f_temp);
                    new_games.add(g_temp);
                }
                f_temp.addGame(g_temp);
            }
            //adicionar jogos novos a games
            for(Game ng: new_games){
                this.games.add(ng);
            }
        }else{
            String description = (String) franchise.get("deck");
            String name = (String) franchise.get("name");
            Franchise new_franchise = new Franchise(id, name, description);
            franchises.add(new_franchise);
        }
    }

    public void populateDevelopers(boolean populateGameList){
        JSONParser parser = new JSONParser();
        JSONArray array = null;
        try {
            array = (JSONArray) parser.parse(readJson("resources/developers.json"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(Object object: array) {
            populateDeveloper(object, populateGameList);
        }
    }

    public void populateDeveloper(Object object, boolean populateGameList){
        JSONObject developer = (JSONObject) object;
        int id = Integer.parseInt(String.valueOf(developer.get("id")));

        if(populateGameList){
            Developer d_temp = findDeveloperID(id);
            //adicionar lista de jogos, revendo se o jogo existe na lista de games
            JSONArray developed_games = (JSONArray) developer.get("developed_games");
            ArrayList<Game> new_games = new ArrayList<Game>();
            for(Object subObject: developed_games) {
                JSONObject game = (JSONObject) subObject;
                final int g_id = Integer.parseInt(String.valueOf(game.get("id")));
                Game g_temp = findGameID(g_id);
                //caso o jogo nao exista em games
                if(g_temp==null){
                    String g_name = (String) game.get("name");
                    //descricao do jogo
                    String g_description = (String) game.get("site_detail_url");
                    g_temp = new Game(g_id, g_name, g_description, "");
                    g_temp.addDeveloper(d_temp);
                    new_games.add(g_temp);
                }
                d_temp.addGameDeveloped(g_temp);
            }
            for(Game ng: new_games){
                this.games.add(ng);
            }
        }else{
            String name = (String) developer.get("name");
            String description = (String) developer.get("deck");
            String country = (String) developer.get("location_country");
            String website = (String) developer.get("website");
            Developer new_developer = new Developer(id, name, description, website, country);
            developers.add(new_developer);
        }
    }

    public void populatePublishers(boolean populateGameList){
        JSONParser parser = new JSONParser();
        JSONArray array = null;
        try {
            array = (JSONArray) parser.parse(readJson("resources/publishers.json"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(Object object: array) {
            populatePublisher(object, populateGameList);
        }
    }

    public void populatePublisher(Object object, boolean populateGameList){
        JSONObject publisher = (JSONObject) object;
        int id = Integer.parseInt(String.valueOf(publisher.get("id")));

        if(populateGameList){
            Publisher p_temp = findPublisherID(id);
            //adicionar lista de jogos, revendo se o jogo existe na lista de games
            JSONArray published_games = (JSONArray) publisher.get("published_games");
            ArrayList<Game> new_games = new ArrayList<Game>();
            for(Object subObject: published_games) {
                JSONObject game = (JSONObject) subObject;
                final int g_id = Integer.parseInt(String.valueOf(game.get("id")));
                Game g_temp = findGameID(g_id);
                //caso o jogo nao exista em games
                if(g_temp==null){
                    String g_name = (String) game.get("name");
                    //descricao do jogo
                    String g_description = (String) game.get("site_detail_url");
                    g_temp = new Game(g_id, g_name, g_description, "");
                    g_temp.addPublisher(p_temp);
                    new_games.add(g_temp);
                }
                p_temp.addGamePublished(g_temp);
            }
            for(Game ng: new_games){
                this.games.add(ng);
            }
        }else{
            String name = (String) publisher.get("name");
            String description = (String) publisher.get("deck");
            String country = (String) publisher.get("location_country");
            String website = (String) publisher.get("website");
            Publisher new_publisher = new Publisher(id, name, description, website, country);
            publishers.add(new_publisher);
        }
    }

    public void populatePlatformsManufacturers(boolean populateGameList){
        JSONParser parser = new JSONParser();
        JSONArray array = null;
        try {
            array = (JSONArray) parser.parse(readJson("resources/platforms.json"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(Object object: array) {
            populatePlatformManufacturers(object, populateGameList);
        }
    }

    public void populatePlatformManufacturers(Object object, boolean populateGameList){
        JSONObject platform = (JSONObject) object;
        int id = Integer.parseInt(String.valueOf(platform.get("id")));

        if(populateGameList){
            for(Game game: games){
                for(Platform game_platform: game.getPlatforms()){
                    game_platform.addGame(game);
                }
            }
        }else{
            String name = (String) platform.get("name");
            String description = (String) platform.get("deck");

            JSONObject manufacturer = (JSONObject) platform.get("company");
            if(manufacturer!=null){
                int m_id = Integer.parseInt(String.valueOf(manufacturer.get("id")));
                Manufacturer m_temp = findManufacturerID(m_id);
                if(m_temp==null){
                    String m_name = (String) manufacturer.get("name");
                    String m_description = (String) manufacturer.get("api_detail_url");
                    m_temp = new Manufacturer(m_id, m_name, m_description, null, null);
                    manufacturers.add(m_temp);
                }
                Platform new_platform = new Platform(id, name, description, m_temp);
                platforms.add(new_platform);
                manufacturers.get(getManufacturerIndex(m_temp)).addPlatformManufactured(new_platform);
            }else{
                Platform new_platform = new Platform(id, name, description, null);
                platforms.add(new_platform);
            }
        }
    }

    public void populateGames(){

        JSONParser parser = new JSONParser();
        JSONArray array = null;
        try {
            array = (JSONArray) parser.parse(readJson("resources/games.json"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(Object object: array) {
            populateGame(object);
        }
    }

    public void populateGame(Object object){

        JSONObject game = (JSONObject) object;
        int id = Integer.parseInt(String.valueOf(game.get("id")));
        String name = (String) game.get("name");
        JSONObject game_images = (JSONObject) game.get("image");
        String image = (String) game_images.get("medium_url");
        String description = (String) game.get("deck");

        //Supondo que franchises já está populada (ainda sem a lista de games nas franchises)
        JSONArray franchises = (JSONArray) game.get("franchises");
        ArrayList<Franchise> franchise_list = new ArrayList<Franchise>();
        if(franchises!=null) {
            for (Object subObject : franchises) {
                JSONObject franchise = (JSONObject) subObject;
                final int f_id = Integer.parseInt(String.valueOf(franchise.get("id")));
                Franchise f_temp = findFranchiseID(f_id);
                if (f_temp != null) franchise_list.add(f_temp);
            }
        }

        //Supondo que developers já está populada (ainda sem a lista de games_developed nos developers)
        JSONArray developers = (JSONArray) game.get("developers");
        ArrayList<Developer> developer_list = new ArrayList<Developer>();
        if(developers!=null) {
            for (Object subObject : developers) {
                JSONObject developer = (JSONObject) subObject;
                final int d_id = Integer.parseInt(String.valueOf(developer.get("id")));
                Developer d_temp = findDeveloperID(d_id);
                if (d_temp != null) developer_list.add(d_temp);
            }
        }

        //Supondo que publishers já está populada (ainda sem a lista de games_developed nos publishers)
        JSONArray publishers = (JSONArray) game.get("publishers");
        ArrayList<Publisher> publisher_list = new ArrayList<Publisher>();
        if(publishers!=null) {
            for (Object subObject : publishers) {
                JSONObject publisher = (JSONObject) subObject;
                final int p_id = Integer.parseInt(String.valueOf(publisher.get("id")));
                Publisher p_temp = findPublisherID(p_id);
                if (p_temp != null) publisher_list.add(p_temp);
            }
        }

        //Supondo que platforms e manufactures já estao populadas (ainda sem a lista de games_developed nos publishers)
        JSONArray platforms = (JSONArray) game.get("platforms");
        ArrayList<Platform> platform_list = new ArrayList<Platform>();
        if(platforms!=null) {
            for (Object subObject : platforms) {
                JSONObject platform = (JSONObject) subObject;
                final int p_id = Integer.parseInt(String.valueOf(platform.get("id")));
                Platform p_temp = findPlatformID(p_id);
                if (p_temp != null) platform_list.add(p_temp);
            }
        }

        //Adicionar genres ao jogo
        JSONArray genres = (JSONArray) game.get("genres");
        ArrayList<String> genre_list = new ArrayList<String>();
        if(genres!=null) {
            for (Object subObject : genres) {
                JSONObject genre = (JSONObject) subObject;
                String g_name = (String) genre.get("name");
                genre_list.add(g_name);
            }
        }

        //Adicionar themes ao jogo
        JSONArray themes = (JSONArray) game.get("themes");
        ArrayList<String> theme_list = new ArrayList<String>();
        if(themes!=null) {
            for (Object subObject : themes) {
                JSONObject theme = (JSONObject) subObject;
                String t_name = (String) theme.get("name");
                theme_list.add(t_name);
            }
        }

        Game new_game = new Game(id, name, description, image, platform_list, publisher_list, developer_list, franchise_list, genre_list, theme_list);
        games.add(new_game);
    }

    private Franchise findFranchiseID(int id){
        for(Franchise francise: this.franchises){
            if(francise.getId() == id){
                return francise;
            }
        }
        return null;
    }

    private Game findGameID(int id){
        for(Game game: this.games){
            if(game.getId() == id){
                return game;
            }
        }
        return null;
    }

    private Developer findDeveloperID(int id) {
        for(Developer developer: this.developers){
            if(developer.getId() == id){
                return developer;
            }
        }
        return null;
    }

    private Publisher findPublisherID(int id) {
        for(Publisher publisher: this.publishers){
            if(publisher.getId() == id){
                return publisher;
            }
        }
        return null;
    }

    private int getManufacturerIndex(Manufacturer obj){
        for(int i = 0; i<manufacturers.size(); i++){
            if(manufacturers.get(i).equals(obj)){
                return i;
            }
        }
        return -1;
    }

    private Platform findPlatformID(int id) {
        for(Platform platform: this.platforms){
            if(platform.getId() == id){
                return platform;
            }
        }
        return null;
    }

    private Manufacturer findManufacturerID(int id) {
        for(Manufacturer manufacturer: this.manufacturers){
            if(manufacturer.getId() == id){
                return manufacturer;
            }
        }
        return null;
    }

    private String readJson(String path){
        try{
            File file = new File(path);
            InputStream json = new FileInputStream(file);
            int size = json.available();
            byte[] buffer = new byte[size];
            json.read(buffer);
            json.close();
            String jsonString = new String(buffer, "UTF-8");
            return jsonString;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            return null;
        }
    }

    public static void main( String[] args ) {
        //OntologyPopulator ont = new OntologyPopulator("resources/ontology_games.owl", "RDF/XML");

        Marshaller marshaller = new Marshaller();

        /*Dataset dataset = TDBFactory.createDataset("dataset1");
        Model tdb = dataset.getDefaultModel();
        FileManager.get().readModel(tdb, "resources/ontology_games.owl", "RDF/XML");
        System.out.println(tdb.toString());
        tdb.close();
        dataset.close();*/
    }
}
