package dataTypes;

import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlObjectProperty;
import com.yoshtec.owl.annotations.dprop.OwlDataPropertyDomain;
import com.yoshtec.owl.annotations.dprop.OwlDataPropertyRange;
import com.yoshtec.owl.annotations.oprop.OwlInverseObjectProperty;
import com.yoshtec.owl.annotations.oprop.OwlIrreflexiveObjectProperty;
import com.yoshtec.owl.annotations.oprop.OwlObjectPropertyDomain;
import com.yoshtec.owl.annotations.oprop.OwlObjectPropertyRange;

import java.util.ArrayList;

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Publisher")
public class Publisher extends Company
{
    @OwlObjectProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasPublished")
    @OwlInverseObjectProperty(inverse="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#isPublishedBy")
    @OwlObjectPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Publisher")
    @OwlObjectPropertyRange(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Game")
    @OwlIrreflexiveObjectProperty
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Game")
    private ArrayList<Game> gamesPublished;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasPublishedGamesTotal")
    @OwlDataPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Publisher")
    @OwlDataPropertyRange(range = "http://www.w3.org/2001/XMLSchema#int")
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
