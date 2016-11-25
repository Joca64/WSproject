package dataTypes;

import java.util.ArrayList;

public class Game
{
    private String id;
    private String name;
    private String description;
    private ArrayList<Platform> platforms;
    private ArrayList<Franchise> franchises;
    private String image;
    private ArrayList<String> genres;
    private ArrayList<String> themes;
    private ArrayList<Developer> developers;
    private ArrayList<Publisher> publishers;

    public Game(String id, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.platforms = new ArrayList<Platform>();
        this.developers = new ArrayList<Developer>();
        this.publishers = new ArrayList<Publisher>();
        this.franchises = new ArrayList<Franchise>();
        this.image = "";
        this.genres = new ArrayList<String>();
        this.themes = new ArrayList<String>();
    }

    public Game(String id, String name, String description, ArrayList<Platform> platforms, ArrayList<Publisher> publishers,
                ArrayList<Developer> developers, ArrayList<Franchise> franchises, ArrayList<String> genres, ArrayList<String> themes)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.platforms = platforms;
        this.developers = developers;
        this.publishers = publishers;
        this.franchises = franchises;
        this.image = "";
        this.genres = genres;
        this.themes = themes;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

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
}
