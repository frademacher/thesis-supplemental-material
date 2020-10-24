package de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas;

import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.gen.NoParkingAreasFoundExceptionGen;

public class NoParkingAreasFoundException extends RuntimeException implements NoParkingAreasFoundExceptionGen {

    protected String noParkingAreasFound;

    protected String errorMessage;

    public NoParkingAreasFoundException(String noParkingAreasFound) {
        super();
        this.noParkingAreasFound = noParkingAreasFound;
    }

    public NoParkingAreasFoundException(String noParkingAreasFound, String errorMessage) {
        super(errorMessage);
        this.noParkingAreasFound = noParkingAreasFound;
        this.errorMessage = errorMessage;
    }
}
