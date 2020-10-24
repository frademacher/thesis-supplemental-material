package de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.gen;

public abstract class ParkingAreaNotFoundExceptionGenImpl extends RuntimeException implements ParkingAreaNotFoundExceptionGen {

    protected String parkingAreaNotFound;

    protected String errorMessage;

    public ParkingAreaNotFoundExceptionGenImpl(String parkingAreaNotFound) {
        super();
        this.parkingAreaNotFound = parkingAreaNotFound;
    }

    public ParkingAreaNotFoundExceptionGenImpl(String parkingAreaNotFound, String errorMessage) {
        super(errorMessage);
        this.parkingAreaNotFound = parkingAreaNotFound;
        this.errorMessage = errorMessage;
    }
}
