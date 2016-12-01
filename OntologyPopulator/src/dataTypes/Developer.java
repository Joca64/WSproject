package dataTypes;

import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlObjectProperty;
import com.yoshtec.owl.annotations.dprop.OwlDataPropertyDomain;
import com.yoshtec.owl.annotations.dprop.OwlDataPropertyRange;
import com.yoshtec.owl.annotations.dprop.OwlFunctionalDataProperty;
import com.yoshtec.owl.annotations.oprop.OwlInverseObjectProperty;
import com.yoshtec.owl.annotations.oprop.OwlIrreflexiveObjectProperty;
import com.yoshtec.owl.annotations.oprop.OwlObjectPropertyDomain;
import com.yoshtec.owl.annotations.oprop.OwlObjectPropertyRange;

import java.util.ArrayList;

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Developer")
public class Developer extends Company
{
    @OwlObjectProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasDeveloped")
    @OwlInverseObjectProperty(inverse="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#isDevelopedBy")
    @OwlObjectPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Developer")
    @OwlObjectPropertyRange(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Game")
    @OwlIrreflexiveObjectProperty
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Game")
    private ArrayList<Game> gamesDeveloped;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasDevelopedGamesTotal")
    @OwlDataPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Developer")
    @OwlDataPropertyRange(range = "http://www.w3.org/2001/XMLSchema#int")
    private int totalGamesDeveloped;

    public Developer(int id, String name, String description, String website, String country)
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
