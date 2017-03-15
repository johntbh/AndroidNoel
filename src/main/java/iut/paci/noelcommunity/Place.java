package iut.paci.noelcommunity;

import android.content.Context;
import android.view.Window;
import android.widget.TextView;

import org.mapsforge.core.model.LatLong;

import java.util.Date;

/**
 * Created by user on 27/02/2017.
 */

abstract class Place {
    int id;
    String name;
    double latitude;
    double longitude;
    Date openingTime;
    Date closingTime;
    int idRessourceLayout;
    int idRessourceImage;

    Place(int id, String name, double latitude, double longitude, Date openingTime, Date closingTime, int idRessourceLayout, int idRessourceImage) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.idRessourceLayout = idRessourceLayout;
        this.idRessourceImage = idRessourceImage;
    }

    abstract void draw(final Context context, final LatLong center);
}
