package de.puls.domain.ChargingStationManagement.gen;

import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.domain.ChargingStationManagement.ChargerSpeed;
import de.puls.domain.ChargingStationManagement.Location;
import de.puls.domain.ChargingStationManagement.TimePeriods;

public abstract class ParkingAreaInformationGenImpl implements DddValueObject, ParkingAreaInformationGen {

    public ParkingAreaInformationGenImpl() {
    }

    protected long ownerId;

    @Override
    public long getOwnerId() {
        return ownerId;
    }

    protected String name;

    @Override
    public String getName() {
        return name;
    }

    protected String description;

    @Override
    public String getDescription() {
        return description;
    }

    protected Location location;

    @Override
    public Location getLocation() {
        return location;
    }

    protected int parkingSpaceCount;

    @Override
    public int getParkingSpaceCount() {
        return parkingSpaceCount;
    }

    protected TimePeriods availability;

    @Override
    public TimePeriods getAvailability() {
        return availability;
    }

    protected float pricePerHour;

    @Override
    public float getPricePerHour() {
        return pricePerHour;
    }

    protected float pricePerKwh;

    @Override
    public float getPricePerKwh() {
        return pricePerKwh;
    }

    protected boolean activated;

    @Override
    public boolean getActivated() {
        return activated;
    }

    protected boolean blocked;

    @Override
    public boolean getBlocked() {
        return blocked;
    }

    protected boolean offered;

    @Override
    public boolean getOffered() {
        return offered;
    }

    protected ChargerSpeed chargerSpeed;

    @Override
    public ChargerSpeed getChargerSpeed() {
        return chargerSpeed;
    }

    protected String plugType;

    @Override
    public String getPlugType() {
        return plugType;
    }

    public ParkingAreaInformationGenImpl(long ownerId, String name, String description, Location location, int parkingSpaceCount, TimePeriods availability, float pricePerHour, float pricePerKwh, boolean activated, boolean blocked, boolean offered, ChargerSpeed chargerSpeed, String plugType) {
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
