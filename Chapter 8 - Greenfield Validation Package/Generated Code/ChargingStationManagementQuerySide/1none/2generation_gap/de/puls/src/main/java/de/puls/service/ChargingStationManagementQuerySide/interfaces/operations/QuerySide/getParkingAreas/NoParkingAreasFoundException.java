package de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas;

import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.gen.NoParkingAreasFoundExceptionGenImpl;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends NoParkingAreasFoundExceptionGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
public class NoParkingAreasFoundException extends NoParkingAreasFoundExceptionGenImpl {

    public NoParkingAreasFoundException(String noParkingAreasFound) {
        super(noParkingAreasFound);
    }

    public NoParkingAreasFoundException(String noParkingAreasFound, String errorMessage) {
        super(noParkingAreasFound, errorMessage);
    }
}
