package de.puls.domain.ChargingStationManagement;

public class Location {

    public Location() {
    }

    private double latitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    private double longitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
