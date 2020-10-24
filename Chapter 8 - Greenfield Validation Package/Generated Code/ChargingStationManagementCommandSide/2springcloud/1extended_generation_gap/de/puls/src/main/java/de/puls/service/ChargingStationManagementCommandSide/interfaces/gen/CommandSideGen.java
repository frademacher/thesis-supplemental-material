package de.puls.service.ChargingStationManagementCommandSide.interfaces.gen;

import de.puls.domain.ChargingStationManagement.CreateParkingAreaCommand;
import de.puls.domain.ChargingStationManagement.UpdateParkingAreaCommand;

public interface CommandSideGen {

    void createParkingArea(CreateParkingAreaCommand command);

    void updateParkingArea(Long id, UpdateParkingAreaCommand command);

    void deleteParkingArea(Long id);

    void sendParkingAreaCreatedEvent();

    void sendParkingAreaUpdatedEvent();

    void sendParkingAreaDeletedEvent();
}
