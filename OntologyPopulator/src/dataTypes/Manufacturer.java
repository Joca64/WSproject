package dataTypes;

import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlObjectProperty;
import com.yoshtec.owl.annotations.dprop.OwlDataPropertyDomain;
import com.yoshtec.owl.annotations.dprop.OwlDataPropertyRange;
import com.yoshtec.owl.annotations.dprop.OwlFunctionalDataProperty;
import com.yoshtec.owl.annotations.oprop.OwlInverseObjectProperty;
import com.yoshtec.owl.annotations.oprop.OwlObjectPropertyDomain;
import com.yoshtec.owl.annotations.oprop.OwlObjectPropertyRange;

import java.util.ArrayList;

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Manufacturer")
public class Manufacturer extends Company
{
    @OwlObjectProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasManufactured")
    @OwlInverseObjectProperty(inverse="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasBeenManufacturedBy")
    @OwlObjectPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Manufacturer")
    @OwlObjectPropertyRange(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Platform")
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Platform")
    private ArrayList<Platform> manufacturedPlatforms;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasManufacturedTotal")
    @OwlDataPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Manufacturer")
    @OwlDataPropertyRange(range = "http://www.w3.org/2001/XMLSchema#int")
    private int totalPlatformsManufactured;

    public Manufacturer(int id, String name, String description, String website, String country)
    {
        super(id, name, description, website, country);
        this.manufacturedPlatforms = new ArrayList<Platform>();
        setTotalPlatformsManufactured();
    }

    public ArrayList<Platform> getManufacturedPlatforms() { return manufacturedPlatforms; }

    public void setManufacturedPlatforms(ArrayList<Platform> manufacturedPlatforms) { this.manufacturedPlatforms = manufacturedPlatforms; }

    public void addPlatformManufactured(Platform platform) { this.manufacturedPlatforms.add(platform); }

    public int getTotalPlatformsManufactured() { return totalPlatformsManufactured; }

    public void setTotalPlatformsManufactured() { this.totalPlatformsManufactured = manufacturedPlatforms.size(); }
}
