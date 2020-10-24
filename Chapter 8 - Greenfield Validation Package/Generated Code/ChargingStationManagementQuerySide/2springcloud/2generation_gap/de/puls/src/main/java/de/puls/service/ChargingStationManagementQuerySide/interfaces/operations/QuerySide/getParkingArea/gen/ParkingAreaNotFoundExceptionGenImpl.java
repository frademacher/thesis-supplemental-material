package de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.gen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
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
