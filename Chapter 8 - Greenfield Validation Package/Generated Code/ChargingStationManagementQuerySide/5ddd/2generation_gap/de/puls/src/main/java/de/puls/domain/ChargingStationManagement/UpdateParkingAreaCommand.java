package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.UpdateParkingAreaCommandGenImpl;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends UpdateParkingAreaCommandGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
public class UpdateParkingAreaCommand extends UpdateParkingAreaCommandGenImpl {

    public UpdateParkingAreaCommand() {
        super();
    }

    public UpdateParkingAreaCommand(ParkingAreaInformation info) {
        super(info);
    }
}
