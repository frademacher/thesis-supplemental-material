package de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea;

public class ParkingAreaNotFoundException extends RuntimeException {

    protected String parkingAreaNotFound;

    protected String errorMessage;

    public ParkingAreaNotFoundException(String parkingAreaNotFound) {
        super();
        this.parkingAreaNotFound = parkingAreaNotFound;
    }

    public ParkingAreaNotFoundException(String parkingAreaNotFound, String errorMessage) {
        super(errorMessage);
        this.parkingAreaNotFound = parkingAreaNotFound;
        this.errorMessage = errorMessage;
    }
}
