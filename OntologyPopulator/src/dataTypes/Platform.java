package dataTypes;

import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.dprop.OwlFunctionalDataProperty;

import java.util.ArrayList;

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Platform")
public class Platform
{
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasPlatformID")
    @OwlFunctionalDataProperty
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#int")
    private int id;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasPlatformName")
    @OwlFunctionalDataProperty
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private String name;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasPlatformDescription")
    @OwlFunctionalDataProperty
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private String description;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasBeenManufacturedBy")
    @OwlFunctionalDataProperty
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Manufacturer")
    private Manufacturer manufacturer;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasGameDevelopedFor")
    @OwlFunctionalDataProperty
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Game")
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
