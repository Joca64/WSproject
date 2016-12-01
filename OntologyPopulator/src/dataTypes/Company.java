package dataTypes;

import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Company")
public class Company
{
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasCompanyID")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#int")
    private int id;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasCompanyName")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private String name;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasCompanyDescription")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private String description;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasCompanyWebsite")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#anyURI")
    private String website;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasCompanyCountry")
    @OwlDataType(uri="http://www.w3.org/2001/XMLSchema#string")
    private String country;

    public Company(int id, String name, String description, String website, String country)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.website = website;
        this.country = country;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }
}
