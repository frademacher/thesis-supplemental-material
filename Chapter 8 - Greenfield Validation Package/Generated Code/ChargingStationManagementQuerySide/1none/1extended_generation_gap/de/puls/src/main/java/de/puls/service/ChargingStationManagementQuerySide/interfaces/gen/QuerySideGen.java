package de.puls.service.ChargingStationManagementQuerySide.interfaces.gen;

import de.puls.domain.ChargingStationManagement.Location;
import de.puls.domain.ChargingStationManagement.ParkingAreaCreatedEvent;
import de.puls.domain.ChargingStationManagement.ParkingAreaDeletedEvent;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformationList;
import de.puls.domain.ChargingStationManagement.ParkingAreaUpdatedEvent;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.ParkingAreaNotFoundException;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.NoParkingAreasFoundException;

public interface QuerySideGen {

    ParkingAreaInformation getParkingArea(Long id) throws ParkingAreaNotFoundException;

    ParkingAreaInformationList getParkingAreas(Location northEastBound, Location southWestBound) throws NoParkingAreasFoundException;

    void receiveParkingAreaCreatedEvent(ParkingAreaCreatedEvent event);

    void receiveParkingAreaUpdatedEvent(ParkingAreaUpdatedEvent event);

    void receiveParkingAreaDeletedEvent(ParkingAreaDeletedEvent event);
}
