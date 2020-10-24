package de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.gen;

public abstract class NoParkingAreasFoundExceptionGenImpl extends RuntimeException implements NoParkingAreasFoundExceptionGen {

    protected String noParkingAreasFound;

    protected String errorMessage;

    public NoParkingAreasFoundExceptionGenImpl(String noParkingAreasFound) {
        super();
        this.noParkingAreasFound = noParkingAreasFound;
    }

    public NoParkingAreasFoundExceptionGenImpl(String noParkingAreasFound, String errorMessage) {
        super(errorMessage);
        this.noParkingAreasFound = noParkingAreasFound;
        this.errorMessage = errorMessage;
    }
}
