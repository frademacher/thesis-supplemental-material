package de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas;

public class NoParkingAreasFoundException extends RuntimeException {

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
