package pl.dabkowski.edp.database.entities;

import lombok.Data;
import pl.dabkowski.edp.exceptions.LocationException;

@Data
public class Location {
    private float longitude;
    private float latitude;

    public Location(float longitude, float latitude) throws LocationException {
        if (longitude >= -180 && longitude <= 180) {
            this.longitude = longitude;
        } else {
            throw new LocationException("Longitude out of bound");
        }
        if (latitude >= -90 && latitude <= 90) {
            this.latitude = latitude;
        } else {
            throw new LocationException("Latitude out of bound");
        }
    }

    public Location(String lo, String lat) throws LocationException {
        float longitude = Float.parseFloat(lo);
        float latitude = Float.parseFloat(lat);
        if (longitude >= -180 && longitude <= 180) {
            this.longitude = longitude;
        } else {
            throw new LocationException("Longitude out of bound");
        }
        if (latitude >= -90 && latitude <= 90) {
            this.latitude = latitude;
        } else {
            throw new LocationException("Latitude out of bound");
        }
    }
}
