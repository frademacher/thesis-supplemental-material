package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.ParkingAreaCreatedEventGenImpl;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends ParkingAreaCreatedEventGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
public class ParkingAreaCreatedEvent extends ParkingAreaCreatedEventGenImpl {

    public ParkingAreaCreatedEvent() {
        super();
    }

    public ParkingAreaCreatedEvent(long parkingAreaId, ParkingAreaInformation info) {
        super(parkingAreaId, info);
    }
}
