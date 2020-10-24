package de.puls.service.ChargingStationManagementQuerySide.interfaces.gen;

import de.puls.domain.ChargingStationManagement.Location;
import de.puls.domain.ChargingStationManagement.ParkingAreaCreatedEvent;
import de.puls.domain.ChargingStationManagement.ParkingAreaDeletedEvent;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformationList;
import de.puls.domain.ChargingStationManagement.ParkingAreaUpdatedEvent;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.ParkingAreaNotFoundException;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.NoParkingAreasFoundException;

public abstract class QuerySideGenImpl implements QuerySideGen {

    @Override
    public ParkingAreaInformation getParkingArea(Long id) throws ParkingAreaNotFoundException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void checkRequiredParametersOfGetParkingArea(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
    }

    @Override
    public ParkingAreaInformationList getParkingAreas(Location northEastBound, Location southWestBound) throws NoParkingAreasFoundException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void checkRequiredParametersOfGetParkingAreas(Location northEastBound, Location southWestBound) {
        if (northEastBound == null)
            throw new IllegalArgumentException("Required parameter \"northEastBound\" must not be null");
        if (southWestBound == null)
            throw new IllegalArgumentException("Required parameter \"southWestBound\" must not be null");
    }

    @Override
    public void receiveParkingAreaCreatedEvent(ParkingAreaCreatedEvent event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void checkRequiredAsyncParametersOfReceiveParkingAreaCreatedEvent(ParkingAreaCreatedEvent event) {
        if (event == null)
            throw new IllegalArgumentException("Required parameter \"event\" must not be null");
    }

    @Override
    public void receiveParkingAreaUpdatedEvent(ParkingAreaUpdatedEvent event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void checkRequiredAsyncParametersOfReceiveParkingAreaUpdatedEvent(ParkingAreaUpdatedEvent event) {
        if (event == null)
            throw new IllegalArgumentException("Required parameter \"event\" must not be null");
    }

    @Override
    public void receiveParkingAreaDeletedEvent(ParkingAreaDeletedEvent event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void checkRequiredAsyncParametersOfReceiveParkingAreaDeletedEvent(ParkingAreaDeletedEvent event) {
        if (event == null)
            throw new IllegalArgumentException("Required parameter \"event\" must not be null");
    }
}
