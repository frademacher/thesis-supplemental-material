package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;

public class Location implements DddValueObject {

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
