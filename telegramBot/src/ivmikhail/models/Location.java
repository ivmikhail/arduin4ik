package ivmikhail.models;

public class Location {
    //    longitude	Float	Longitude as defined by sender
    private float longitude;
    //    latitude	Float	Latitude as defined by sender
    private float latitude;

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
