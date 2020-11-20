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

    private int parkingSpaceCount;

    public int getParkingSpaceCount() {
        return parkingSpaceCount;
    }

    private TimePeriods availability;

    public TimePeriods getAvailability() {
        return availability;
    }

    private float pricePerHour;

    public float getPricePerHour() {
        return pricePerHour;
    }

    private float pricePerKwh;

    public float getPricePerKwh() {
        return pricePerKwh;
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

    private ChargerSpeed chargerSpeed;

    public ChargerSpeed getChargerSpeed() {
        return chargerSpeed;
    }

    private String plugType;

    public String getPlugType() {
        return plugType;
    }

    public ParkingAreaInformation(long ownerId, String name, String description, Location location, int parkingSpaceCount, TimePeriods availability, float pricePerHour, float pricePerKwh, boolean activated, boolean blocked, boolean offered, ChargerSpeed chargerSpeed, String plugType) {
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.parkingSpaceCount = parkingSpaceCount;
        this.availability = availability;
        this.pricePerHour = pricePerHour;
        this.pricePerKwh = pricePerKwh;
        this.activated = activated;
        this.blocked = blocked;
        this.offered = offered;
        this.chargerSpeed = chargerSpeed;
        this.plugType = plugType;
    }
}
