package dataTypes;

public class Company
{
    private int id;
    private String name;
    private String description;
    private String website;
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
