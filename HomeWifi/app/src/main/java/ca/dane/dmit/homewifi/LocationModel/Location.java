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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
    public Location() {
        this.description = getDescription();
        this.lat = getLat();
        this.lng = getLng();
        this.isActive = getActive();
    }
    public Location(int id, String description, double lat, double lng, Boolean isActive) {
        this.id = id;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.isActive = isActive;
    }

    public Location(String description, double lat, double lng, Boolean isActive) {
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.isActive = isActive;
    }

    public Location(String description, double lat, double lng) {
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.isActive = true;
    }

    public Boolean getActive() {
        return isActive;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getDescription() {
        return description;
    }


}
