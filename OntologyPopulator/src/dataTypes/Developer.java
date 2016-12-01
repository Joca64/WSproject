package dataTypes;

import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.dprop.OwlFunctionalDataProperty;

import java.util.ArrayList;

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Developer")
public class Developer extends Company
{
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasDeveloped")
    @OwlFunctionalDataProperty
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Game")
    private ArrayList<Game> gamesDeveloped;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasDevelopedGamesTotal")
    @OwlFunctionalDataProperty
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#int")
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
