package iut.paci.noelcommunity;

public class District
{
    int id;
    String name;
    String description;
    double longitude;
    double latitude;
    int imageRessourceId;

    public District(int id, String name, String description, double longitude, double latitude, int imageRessourceId)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.imageRessourceId = imageRessourceId;
    }
}
