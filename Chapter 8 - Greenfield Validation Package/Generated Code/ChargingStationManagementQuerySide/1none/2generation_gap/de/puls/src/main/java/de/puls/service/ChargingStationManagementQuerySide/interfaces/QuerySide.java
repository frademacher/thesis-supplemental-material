package de.puls.service.ChargingStationManagementQuerySide.interfaces;

import de.puls.domain.ChargingStationManagement.Location;
import de.puls.domain.ChargingStationManagement.ParkingAreaCreatedEvent;
import de.puls.domain.ChargingStationManagement.ParkingAreaDeletedEvent;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformationList;
import de.puls.domain.ChargingStationManagement.ParkingAreaUpdatedEvent;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.gen.QuerySideGenImpl;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.ParkingAreaNotFoundException;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.NoParkingAreasFoundException;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends QuerySideGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
public class QuerySide extends QuerySideGenImpl {

    @Override
    public ParkingAreaInformation getParkingArea(Long id) throws ParkingAreaNotFoundException {
        checkRequiredParametersOfGetParkingArea(id);
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        return super.getParkingArea(id);
    }

    @Override
    public ParkingAreaInformationList getParkingAreas(Location northEastBound, Location southWestBound) throws NoParkingAreasFoundException {
        checkRequiredParametersOfGetParkingAreas(northEastBound, southWestBound);
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        return super.getParkingAreas(northEastBound, southWestBound);
    }

    @Override
    public void receiveParkingAreaCreatedEvent(ParkingAreaCreatedEvent event) {
        checkRequiredAsyncParametersOfReceiveParkingAreaCreatedEvent(event);
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        super.receiveParkingAreaCreatedEvent(event);
    }

    @Override
    public void receiveParkingAreaUpdatedEvent(ParkingAreaUpdatedEvent event) {
        checkRequiredAsyncParametersOfReceiveParkingAreaUpdatedEvent(event);
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        super.receiveParkingAreaUpdatedEvent(event);
    }

    @Override
    public void receiveParkingAreaDeletedEvent(ParkingAreaDeletedEvent event) {
        checkRequiredAsyncParametersOfReceiveParkingAreaDeletedEvent(event);
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        super.receiveParkingAreaDeletedEvent(event);
    }

    public QuerySide() {
    }
}
