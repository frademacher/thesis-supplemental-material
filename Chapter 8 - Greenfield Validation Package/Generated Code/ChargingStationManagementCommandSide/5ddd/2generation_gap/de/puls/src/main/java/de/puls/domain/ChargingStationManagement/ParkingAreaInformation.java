package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.ParkingAreaInformationGenImpl;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends ParkingAreaInformationGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
public class ParkingAreaInformation extends ParkingAreaInformationGenImpl {

    public ParkingAreaInformation() {
        super();
    }

    public ParkingAreaInformation(long ownerId, String name, String description, Location location, int spacesCount, TimePeriods availability, float pricePerHour, boolean activated, boolean blocked, boolean offered, float pricePerKwh, ChargerSpeed chargerSpeed, String plugType) {
        super(ownerId, name, description, location, spacesCount, availability, pricePerHour, activated, blocked, offered, pricePerKwh, chargerSpeed, plugType);
    }
}
