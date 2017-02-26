package iut.paci.noelcommunity;

import java.util.Date;

/**
 * Created by user on 27/02/2017.
 */

class Place {
    int id;
    String name;
    double latitude;
    double longitude;
    Date openingTime;
    Date closingTime;

    Place(int id, String name, double latitude, double longitude, Date openingTime, Date closingTime) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
}
