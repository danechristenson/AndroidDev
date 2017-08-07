package ca.dane.dmit.homewifi.LocationModel;

import java.util.UUID;

/**
 * Created by super on 8/6/2017.
 */

public class Location {
    public int id;
    public String description;
    public double lat, lng;
    public Boolean isActive;

    public Location(int id, String description, double lat, double lng, Boolean isActive){
        this.id = id;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.isActive = isActive;
    }

    public Location(String description, double lat, double lng, Boolean isActive){
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.isActive = isActive;
    }

    public Location(String description, double lat, double lng){
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.isActive = true;
    }


}
