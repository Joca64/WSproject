package dataTypes;

import java.util.ArrayList;

public class Manufacturer extends Company
{
    private ArrayList<Platform> manufacturedPlatforms;
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
