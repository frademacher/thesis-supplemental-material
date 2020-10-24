package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.ParkingAreaFactoryGenImpl;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends ParkingAreaFactoryGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
public class ParkingAreaFactory extends ParkingAreaFactoryGenImpl {

    static public ParkingArea fromParkingAreaInformation(ParkingAreaInformation info) {
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        return ParkingAreaFactoryGenImpl.fromParkingAreaInformation(info);
    }

    public ParkingAreaFactory() {
        super();
    }
}
