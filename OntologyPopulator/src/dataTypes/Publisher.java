package dataTypes;

import java.net.URI;
import java.util.ArrayList;

public class Publisher extends Company
{
    private ArrayList<Game> gamesPublished;
    private int totalGamesPublished;

    public Publisher(int id, String name, String description, URI website, String country)
    {
        super(id, name, description, website, country);
        this.gamesPublished = new ArrayList<Game>();
        setTotalGamesPublished();
    }

    public ArrayList<Game> getGamesPublished() { return gamesPublished; }

    public void setGamesPublished(ArrayList<Game> gamesPublished) { this.gamesPublished = gamesPublished; }

    public void addGamePublished(Game game){ this.gamesPublished.add(game); }

    public int getTotalGamesPublished() { return totalGamesPublished; }

    public void setTotalGamesPublished() { this.totalGamesPublished = gamesPublished.size(); }
}
