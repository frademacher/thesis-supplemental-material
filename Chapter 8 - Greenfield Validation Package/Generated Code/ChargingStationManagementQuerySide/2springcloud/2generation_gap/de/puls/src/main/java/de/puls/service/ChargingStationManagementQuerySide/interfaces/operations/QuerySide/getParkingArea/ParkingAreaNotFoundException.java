package de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea;

import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.gen.ParkingAreaNotFoundExceptionGenImpl;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends ParkingAreaNotFoundExceptionGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
public class ParkingAreaNotFoundException extends ParkingAreaNotFoundExceptionGenImpl {

    public ParkingAreaNotFoundException(String parkingAreaNotFound) {
        super(parkingAreaNotFound);
    }

    public ParkingAreaNotFoundException(String parkingAreaNotFound, String errorMessage) {
        super(parkingAreaNotFound, errorMessage);
    }
}
