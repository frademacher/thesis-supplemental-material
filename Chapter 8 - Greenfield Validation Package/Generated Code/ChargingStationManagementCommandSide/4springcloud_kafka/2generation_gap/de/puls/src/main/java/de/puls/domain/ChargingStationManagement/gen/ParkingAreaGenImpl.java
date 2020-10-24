package de.puls.domain.ChargingStationManagement.gen;

import de.puls.domain.ChargingStationManagement.ChargerSpeed;
import de.puls.domain.ChargingStationManagement.Location;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.domain.ChargingStationManagement.TimePeriods;
import java.util.Date;
import javax.persistence.Entity;

@Entity()
public abstract class ParkingAreaGenImpl implements ParkingAreaGen {

    public ParkingAreaGenImpl() {
    }

    protected long id;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    protected long ownerId;

    @Override
    public long getOwnerId() {
        return ownerId;
    }

    @Override
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    protected String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    protected String description;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    protected Location location;

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    protected int parkingSpaceCount;

    @Override
    public int getParkingSpaceCount() {
        return parkingSpaceCount;
    }

    @Override
    public void setParkingSpaceCount(int parkingSpaceCount) {
        this.parkingSpaceCount = parkingSpaceCount;
    }

    protected TimePeriods availability;

    @Override
    public TimePeriods getAvailability() {
        return availability;
    }

    @Override
    public void setAvailability(TimePeriods availability) {
        this.availability = availability;
    }

    protected float pricePerHour;

    @Override
    public float getPricePerHour() {
        return pricePerHour;
    }

    @Override
    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    protected float pricePerKwh;

    @Override
    public float getPricePerKwh() {
        return pricePerKwh;
    }

    @Override
    public void setPricePerKwh(float pricePerKwh) {
        this.pricePerKwh = pricePerKwh;
    }

    protected ChargerSpeed chargerSpeed;

    @Override
    public ChargerSpeed getChargerSpeed() {
        return chargerSpeed;
    }

    @Override
    public void setChargerSpeed(ChargerSpeed chargerSpeed) {
        this.chargerSpeed = chargerSpeed;
    }

    protected String plugType;

    @Override
    public String getPlugType() {
        return plugType;
    }

    @Override
    public void setPlugType(String plugType) {
        this.plugType = plugType;
    }

    protected boolean activated;

    @Override
    public boolean getActivated() {
        return activated;
    }

    @Override
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    protected boolean blocked;

    @Override
    public boolean getBlocked() {
        return blocked;
    }

    @Override
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    protected boolean offered;

    @Override
    public boolean getOffered() {
        return offered;
    }

    @Override
    public void setOffered(boolean offered) {
        this.offered = offered;
    }

    protected Date createdDate;

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    protected Date lastModifiedDate;

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public ParkingAreaGenImpl(long id, long ownerId, String name, String description, Location location, int parkingSpaceCount, TimePeriods availability, float pricePerHour, float pricePerKwh, ChargerSpeed chargerSpeed, String plugType, boolean activated, boolean blocked, boolean offered, Date createdDate, Date lastModifiedDate) {
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
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
