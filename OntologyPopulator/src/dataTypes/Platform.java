package dataTypes;

import java.util.ArrayList;

public class Platform
{
    private int id;
    private String name;
    private String description;
    private Manufacturer manufacturer;
    private ArrayList<Game> games;


    public Platform(int id, String name, String description, Manufacturer manufacturer)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.games = new ArrayList<Game>();
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Manufacturer getManufacturer() { return manufacturer; }

    public void setManufacturer(Manufacturer manufacturer) { this.manufacturer = manufacturer; }

    public ArrayList<Game> getGames() { return games; }

    public void setGames(ArrayList<Game> games) { this.games = games; }

    public Game getGame(int index) { return this.games.get(index); }

    public void addGame(Game game) { this.games.add(game); }
}
