package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.ParkingAreaGen;
import java.util.Date;
import javax.persistence.Entity;

@Entity()
public class ParkingArea implements ParkingAreaGen {

    public ParkingArea() {
    }

    private long id;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    private long ownerId;

    @Override
    public long getOwnerId() {
        return ownerId;
    }

    @Override
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    private Location location;

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    private int parkingSpaceCount;

    @Override
    public int getParkingSpaceCount() {
        return parkingSpaceCount;
    }

    @Override
    public void setParkingSpaceCount(int parkingSpaceCount) {
        this.parkingSpaceCount = parkingSpaceCount;
    }

    private TimePeriods availability;

    @Override
    public TimePeriods getAvailability() {
        return availability;
    }

    @Override
    public void setAvailability(TimePeriods availability) {
        this.availability = availability;
    }

    private float pricePerHour;

    @Override
    public float getPricePerHour() {
        return pricePerHour;
    }

    @Override
    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    private float pricePerKwh;

    @Override
    public float getPricePerKwh() {
        return pricePerKwh;
    }

    @Override
    public void setPricePerKwh(float pricePerKwh) {
        this.pricePerKwh = pricePerKwh;
    }

    private ChargerSpeed chargerSpeed;

    @Override
    public ChargerSpeed getChargerSpeed() {
        return chargerSpeed;
    }

    @Override
    public void setChargerSpeed(ChargerSpeed chargerSpeed) {
        this.chargerSpeed = chargerSpeed;
    }

    private String plugType;

    @Override
    public String getPlugType() {
        return plugType;
    }

    @Override
    public void setPlugType(String plugType) {
        this.plugType = plugType;
    }

    private boolean activated;

    @Override
    public boolean getActivated() {
        return activated;
    }

    @Override
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    private boolean blocked;

    @Override
    public boolean getBlocked() {
        return blocked;
    }

    @Override
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    private boolean offered;

    @Override
    public boolean getOffered() {
        return offered;
    }

    @Override
    public void setOffered(boolean offered) {
        this.offered = offered;
    }

    private Date createdDate;

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    private Date lastModifiedDate;

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
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

    @Override
    public ParkingAreaInformation toParkingAreaInformation() {
        /* FIXME If you safely want to implement this method, create an extension interface called 
ParkingAreaExt in the same folder as this class file and run the code 
generator again. Otherwise, this file and all your changes to it will probably get overwritten 
the next time the code generator is executed. */
        throw new UnsupportedOperationException("Not implemented");
    }
}
