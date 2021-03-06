package dataTypes;

import java.net.URI;
import java.util.ArrayList;

public class Developer extends Company
{
    private ArrayList<Game> gamesDeveloped;
    private int totalGamesDeveloped;

    public Developer(int id, String name, String description, URI website, String country)
    {
        super(id, name, description, website, country);
        this.gamesDeveloped = new ArrayList<Game>();
        setTotalGamesDeveloped();
    }

    public ArrayList<Game> getGamesDeveloped() { return gamesDeveloped; }

    public void setGamesDeveloped(ArrayList<Game> gamesDeveloped) { this.gamesDeveloped = gamesDeveloped; }

    public void addGameDeveloped(Game game) { this.gamesDeveloped.add(game); }

    public int getTotalGamesDeveloped() { return totalGamesDeveloped; }

    public void setTotalGamesDeveloped() { this.totalGamesDeveloped = gamesDeveloped.size(); }

}
