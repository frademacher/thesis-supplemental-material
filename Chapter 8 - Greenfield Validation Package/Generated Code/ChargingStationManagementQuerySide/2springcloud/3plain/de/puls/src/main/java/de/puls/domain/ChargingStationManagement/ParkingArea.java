package de.puls.domain.ChargingStationManagement;

import java.util.Date;
import javax.persistence.Entity;

@Entity()
public class ParkingArea {

    public ParkingArea() {
    }

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long ownerId;

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private int parkingSpaceCount;

    public int getParkingSpaceCount() {
        return parkingSpaceCount;
    }

    public void setParkingSpaceCount(int parkingSpaceCount) {
        this.parkingSpaceCount = parkingSpaceCount;
    }

    private TimePeriods availability;

    public TimePeriods getAvailability() {
        return availability;
    }

    public void setAvailability(TimePeriods availability) {
        this.availability = availability;
    }

    private float pricePerHour;

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    private float pricePerKwh;

    public float getPricePerKwh() {
        return pricePerKwh;
    }

    public void setPricePerKwh(float pricePerKwh) {
        this.pricePerKwh = pricePerKwh;
    }

    private ChargerSpeed chargerSpeed;

    public ChargerSpeed getChargerSpeed() {
        return chargerSpeed;
    }

    public void setChargerSpeed(ChargerSpeed chargerSpeed) {
        this.chargerSpeed = chargerSpeed;
    }

    private String plugType;

    public String getPlugType() {
        return plugType;
    }

    public void setPlugType(String plugType) {
        this.plugType = plugType;
    }

    private boolean activated;

    public boolean getActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    private boolean blocked;

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    private boolean offered;

    public boolean getOffered() {
        return offered;
    }

    public void setOffered(boolean offered) {
        this.offered = offered;
    }

    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    private Date lastModifiedDate;

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public ParkingArea(long id, long ownerId, String name, String description, Location location, int parkingSpaceCount, TimePeriods availability, float pricePerHour, float pricePerKwh, ChargerSpeed chargerSpeed, String plugType, boolean activated, boolean blocked, boolean offered, Date createdDate, Date lastModifiedDate) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.parkingSpaceCount = parkingSpaceCount;
        this.availability = availability;
        this.pricePerHour = pricePerHour;
        this.pricePerKwh = pricePerKwh;
        this.chargerSpeed = chargerSpeed;
        this.plugType = plugType;
        this.activated = activated;
        this.blocked = blocked;
        this.offered = offered;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public ParkingAreaInformation toParkingAreaInformation() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
