package de.puls.domain.ChargingStationManagement.gen;

import de.puls.domain.ChargingStationManagement.ChargerSpeed;
import de.puls.domain.ChargingStationManagement.Location;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.domain.ChargingStationManagement.TimePeriods;
import java.util.Date;

public interface ParkingAreaGen {

    long getId();

    void setId(long id);

    long getOwnerId();

    void setOwnerId(long ownerId);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    Location getLocation();

    void setLocation(Location location);

    int getParkingSpaceCount();

    void setParkingSpaceCount(int parkingSpaceCount);

    TimePeriods getAvailability();

    void setAvailability(TimePeriods availability);

    float getPricePerHour();

    void setPricePerHour(float pricePerHour);

    float getPricePerKwh();

    void setPricePerKwh(float pricePerKwh);

    ChargerSpeed getChargerSpeed();

    void setChargerSpeed(ChargerSpeed chargerSpeed);

    String getPlugType();

    void setPlugType(String plugType);

    boolean getActivated();

    void setActivated(boolean activated);

    boolean getBlocked();

    void setBlocked(boolean blocked);

    boolean getOffered();

    void setOffered(boolean offered);

    Date getCreatedDate();

    Date getLastModifiedDate();

    void setLastModifiedDate(Date lastModifiedDate);

    ParkingAreaInformation toParkingAreaInformation();
}
