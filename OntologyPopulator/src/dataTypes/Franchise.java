package dataTypes;

import java.util.ArrayList;

public class Franchise
{
    private int id;
    private String name;
    private String description;
    private ArrayList<Game> games;

    public Franchise(int id, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.games = new ArrayList<Game>();
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public ArrayList<Game> getGames() { return games; }

    public void setGames(ArrayList<Game> games) { this.games = games; }

    public void addGame(Game game) { this.games.add(game); }

    public Game getGame(int index) { return this.games.get(index); }

    public String toString() { return this.getName(); }
}