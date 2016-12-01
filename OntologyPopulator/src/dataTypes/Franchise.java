package dataTypes;

import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;

import java.util.ArrayList;

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Franchise")
public class Franchise
{
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasFranchiseID")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#int")
    private int id;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasFranchiseName")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private String name;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasFranchiseDescription")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private String description;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasGame")
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Game")
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