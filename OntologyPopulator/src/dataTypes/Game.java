package dataTypes;

import java.net.URI;
import java.util.ArrayList;

public class Game
{
    private int id;
    private String name;
    private String description;
    private ArrayList<Platform> platforms;
    private ArrayList<Franchise> franchises;
    private URI image;
    private ArrayList<String> genres;
    private ArrayList<String> themes;
    private ArrayList<Developer> developers;
    private ArrayList<Publisher> publishers;

    public Game(int id, String name, String description, URI image)
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

    public Game(int id, String name, String description, URI image, ArrayList<Platform> platforms, ArrayList<Publisher> publishers,
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

    public URI getImage() { return image; }

    public void setImage(URI image) { this.image = image; }

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
