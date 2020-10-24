package de.puls.service.ChargingStationManagementQuerySide.interfaces;

import de.puls.domain.ChargingStationManagement.Location;
import de.puls.domain.ChargingStationManagement.ParkingAreaCreatedEvent;
import de.puls.domain.ChargingStationManagement.ParkingAreaDeletedEvent;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformationList;
import de.puls.domain.ChargingStationManagement.ParkingAreaUpdatedEvent;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.ParkingAreaNotFoundException;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.NoParkingAreasFoundException;

public class QuerySide {

    public ParkingAreaInformation getParkingArea(Long id) throws ParkingAreaNotFoundException {
        checkRequiredParametersOfGetParkingArea(id);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void checkRequiredParametersOfGetParkingArea(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
    }

    public ParkingAreaInformationList getParkingAreas(Location northEastBound, Location southWestBound) throws NoParkingAreasFoundException {
        checkRequiredParametersOfGetParkingAreas(northEastBound, southWestBound);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void checkRequiredParametersOfGetParkingAreas(Location northEastBound, Location southWestBound) {
        if (northEastBound == null)
            throw new IllegalArgumentException("Required parameter \"northEastBound\" must not be null");
        if (southWestBound == null)
            throw new IllegalArgumentException("Required parameter \"southWestBound\" must not be null");
    }

    public void receiveParkingAreaCreatedEvent(ParkingAreaCreatedEvent event) {
        checkRequiredAsyncParametersOfReceiveParkingAreaCreatedEvent(event);
    }

    private void checkRequiredAsyncParametersOfReceiveParkingAreaCreatedEvent(ParkingAreaCreatedEvent event) {
        if (event == null)
            throw new IllegalArgumentException("Required parameter \"event\" must not be null");
    }

    public void receiveParkingAreaUpdatedEvent(ParkingAreaUpdatedEvent event) {
        checkRequiredAsyncParametersOfReceiveParkingAreaUpdatedEvent(event);
    }

    private void checkRequiredAsyncParametersOfReceiveParkingAreaUpdatedEvent(ParkingAreaUpdatedEvent event) {
        if (event == null)
            throw new IllegalArgumentException("Required parameter \"event\" must not be null");
    }

    public void receiveParkingAreaDeletedEvent(ParkingAreaDeletedEvent event) {
        checkRequiredAsyncParametersOfReceiveParkingAreaDeletedEvent(event);
    }

    private void checkRequiredAsyncParametersOfReceiveParkingAreaDeletedEvent(ParkingAreaDeletedEvent event) {
        if (event == null)
            throw new IllegalArgumentException("Required parameter \"event\" must not be null");
    }
}
