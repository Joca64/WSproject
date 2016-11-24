package dataTypes;

public class Game
{
    private String id;
    private String name;
    private String description;
    private Platform platform;
    private Franchise franchise;
    private String image;
    private String genre; //Remember to change this in case there can be multiple genres
    private String theme; //Remember to change this in case there can be multiple themes
    private Developer developer;
    private Publisher publisher;

    public Game(String id, String name, String description, Platform platform, Developer developer, Publisher publisher)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.platform = platform;
        this.developer = developer;
        this.publisher = publisher;
        this.franchise = null;
        this.image = "";
        this.genre = "";
        this.theme = "";
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Platform getPlatform() { return platform; }

    public void setPlatform(Platform platform) { this.platform = platform; }

    public Franchise getFranchise() { return franchise; }

    public void setFranchise(Franchise franchise) { this.franchise = franchise; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public String getTheme() { return theme; }

    public void setTheme(String theme) { this.theme = theme; }

    public Developer getDeveloper() { return developer; }

    public void setDeveloper(Developer developer) { this.developer = developer; }

    public Publisher getPublisher() { return publisher; }

    public void setPublisher(Publisher publisher) { this.publisher = publisher; }
}
