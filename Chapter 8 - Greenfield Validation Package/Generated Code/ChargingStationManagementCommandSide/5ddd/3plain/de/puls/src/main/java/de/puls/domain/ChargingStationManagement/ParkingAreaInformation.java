package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;

public class ParkingAreaInformation implements DddValueObject {

    public ParkingAreaInformation() {
    }

    private long ownerId;

    public long getOwnerId() {
        return ownerId;
    }

    private String name;

    public String getName() {
        return name;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    private Location location;

    public Location getLocation() {
        return location;
    }

    private int spacesCount;

    public int getSpacesCount() {
        return spacesCount;
    }

    private TimePeriods availability;

    public TimePeriods getAvailability() {
        return availability;
    }

    private float pricePerHour;

    public float getPricePerHour() {
        return pricePerHour;
    }

    private boolean activated;

    public boolean getActivated() {
        return activated;
    }

    private boolean blocked;

    public boolean getBlocked() {
        return blocked;
    }

    private boolean offered;

    public boolean getOffered() {
        return offered;
    }

    private float pricePerKwh;

    public float getPricePerKwh() {
        return pricePerKwh;
    }

    private ChargerSpeed chargerSpeed;

    public ChargerSpeed getChargerSpeed() {
        return chargerSpeed;
    }

    private String plugType;

    public String getPlugType() {
        return plugType;
    }

    public ParkingAreaInformation(long ownerId, String name, String description, Location location, int spacesCount, TimePeriods availability, float pricePerHour, boolean activated, boolean blocked, boolean offered, float pricePerKwh, ChargerSpeed chargerSpeed, String plugType) {
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.spacesCount = spacesCount;
        this.availability = availability;
        this.pricePerHour = pricePerHour;
        this.activated = activated;
        this.blocked = blocked;
        this.offered = offered;
        this.pricePerKwh = pricePerKwh;
        this.chargerSpeed = chargerSpeed;
        this.plugType = plugType;
    }
}
