package de.puls.domain.ChargingStationManagement.gen;

import de.puls.domain.ChargingStationManagement.ChargerSpeed;
import de.puls.domain.ChargingStationManagement.Location;
import de.puls.domain.ChargingStationManagement.TimePeriods;

public interface ParkingAreaInformationGen {

    long getOwnerId();

    String getName();

    String getDescription();

    Location getLocation();

    int getParkingSpaceCount();

    TimePeriods getAvailability();

    float getPricePerHour();

    float getPricePerKwh();

    boolean getActivated();

    boolean getBlocked();

    boolean getOffered();

    ChargerSpeed getChargerSpeed();

    String getPlugType();
}
