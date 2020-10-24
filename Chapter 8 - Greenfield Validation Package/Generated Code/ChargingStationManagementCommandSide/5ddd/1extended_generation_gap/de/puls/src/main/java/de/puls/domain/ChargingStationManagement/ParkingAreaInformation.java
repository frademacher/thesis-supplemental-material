package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.domain.ChargingStationManagement.gen.ParkingAreaInformationGen;

public class ParkingAreaInformation implements DddValueObject, ParkingAreaInformationGen {

    public ParkingAreaInformation() {
    }

    private long ownerId;

    @Override
    public long getOwnerId() {
        return ownerId;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }

    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    private Location location;

    @Override
    public Location getLocation() {
        return location;
    }

    private int spacesCount;

    @Override
    public int getSpacesCount() {
        return spacesCount;
    }

    private TimePeriods availability;

    @Override
    public TimePeriods getAvailability() {
        return availability;
    }

    private float pricePerHour;

    @Override
    public float getPricePerHour() {
        return pricePerHour;
    }

    private boolean activated;

    @Override
    public boolean getActivated() {
        return activated;
    }

    private boolean blocked;

    @Override
    public boolean getBlocked() {
        return blocked;
    }

    private boolean offered;

    @Override
    public boolean getOffered() {
        return offered;
    }

    private float pricePerKwh;

    @Override
    public float getPricePerKwh() {
        return pricePerKwh;
    }

    private ChargerSpeed chargerSpeed;

    @Override
    public ChargerSpeed getChargerSpeed() {
        return chargerSpeed;
    }

    private String plugType;

    @Override
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
