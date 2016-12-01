package dataTypes;

import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;

import java.util.ArrayList;

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Game")
public class Game
{
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasGameID")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#int")
    private int id;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasGameName")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private String name;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasGameDescription")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private String description;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#developedForPlatform")
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Platform")
    private ArrayList<Platform> platforms;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#belongsToFranchise")
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Franchise")
    private ArrayList<Franchise> franchises;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasGameImage")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#anyURI")
    private String image;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasGameGenre")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private ArrayList<String> genres;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasGameTheme")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private ArrayList<String> themes;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#isDevelopedBy")
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Developer")
    private ArrayList<Developer> developers;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#isPublishedBy")
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Publisher")
    private ArrayList<Publisher> publishers;

    public Game(int id, String name, String description, String image)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.platforms = new ArrayList<Platform>();
        this.developers = new ArrayList<Developer>();
        this.publishers = new ArrayList<Publisher>();
        this.franchises = new ArrayList<Franchise>();
        this.image = image;
        this.genres = new ArrayList<String>();
        this.themes = new ArrayList<String>();
    }

    public Game(int id, String name, String description, String image, ArrayList<Platform> platforms, ArrayList<Publisher> publishers,
                ArrayList<Developer> developers, ArrayList<Franchise> franchises, ArrayList<String> genres, ArrayList<String> themes)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.platforms = platforms;
        this.developers = developers;
        this.publishers = publishers;
        this.franchises = franchises;
        this.image = image;
        this.genres = genres;
        this.themes = themes;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public ArrayList<Platform> getPlatforms() { return platforms; }

    public void setPlatform(ArrayList<Platform> platform) { this.platforms = platform; }

    public void addPlatform(Platform platform) { this.platforms.add(platform); }

    public ArrayList<Franchise> getFranchises() { return this.franchises; }

    public Franchise getFranchise(int index) { return this.franchises.get(index); }

    public void addFranchise(Franchise franchise) { this.franchises.add(franchise); }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public ArrayList<String> getGenres() { return this.genres; }

    public String getGenre(int index) { return this.genres.get(index); }

    public void addGenre(String genre) { this.genres.add(genre); }

    public ArrayList<String> getThemes() { return this.themes; }

    public String getTheme(int index) { return this.themes.get(index); }

    public void addTheme(String theme) { this.themes.add(theme); }

    public ArrayList<Developer> getDevelopers() { return this.developers; }

    public Developer getDeveloper(int index) { return this.developers.get(index); }

    public void addDeveloper(Developer developer) { this.developers.add(developer); }

    public ArrayList<Publisher> getPublishers() { return this.publishers; }

    public Publisher getPublisher(int index) { return this.publishers.get(index); }

    public void addPublisher(Publisher publisher) { this.publishers.add(publisher); }

    public String toString(){
        StringBuilder game_string = new StringBuilder();
        game_string.append("["+id+"]");
        game_string.append(name+":");
        for(String g: this.genres){
            game_string.append(g+",");
        }
        game_string.append(":");
        for(String t: this.themes){
            game_string.append(t+",");
        }
        game_string.append(":");
        for(Franchise f: this.franchises){
            game_string.append(f.getName()+",");
        }
        game_string.append(":");
        for(Publisher p: this.publishers){
            game_string.append(p.getName()+",");
        }
        game_string.append(":");
        for(Developer d: this.developers){
            game_string.append(d.getName()+",");
        }
        return game_string.toString();
    }
}
