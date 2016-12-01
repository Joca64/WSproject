package dataTypes;

import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;

import java.util.ArrayList;

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Publisher")
public class Publisher extends Company
{
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasPublished")
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Game")
    private ArrayList<Game> gamesPublished;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasPublishedGamesTotal")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#int")
    private int totalGamesPublished;

    public Publisher(int id, String name, String description, String website, String country)
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
