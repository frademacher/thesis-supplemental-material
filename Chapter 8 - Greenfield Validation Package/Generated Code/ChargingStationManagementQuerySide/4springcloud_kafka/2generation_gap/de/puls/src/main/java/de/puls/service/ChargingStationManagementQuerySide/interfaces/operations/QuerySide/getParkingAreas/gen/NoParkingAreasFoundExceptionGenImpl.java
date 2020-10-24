package de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.gen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
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
