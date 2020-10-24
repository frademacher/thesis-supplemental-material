package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.ParkingAreaGenImpl;
import java.util.Date;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends ParkingAreaGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
public class ParkingArea extends ParkingAreaGenImpl {

    @Override
    public ParkingAreaInformation toParkingAreaInformation() {
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        return super.toParkingAreaInformation();
    }

    public ParkingArea() {
        super();
    }

    public ParkingArea(long id, long ownerId, String name, String description, Location location, int parkingSpaceCount, TimePeriods availability, float pricePerHour, float pricePerKwh, ChargerSpeed chargerSpeed, String plugType, boolean activated, boolean blocked, boolean offered, Date createdDate, Date lastModifiedDate) {
        super(id, ownerId, name, description, location, parkingSpaceCount, availability, pricePerHour, pricePerKwh, chargerSpeed, plugType, activated, blocked, offered, createdDate, lastModifiedDate);
    }
}
