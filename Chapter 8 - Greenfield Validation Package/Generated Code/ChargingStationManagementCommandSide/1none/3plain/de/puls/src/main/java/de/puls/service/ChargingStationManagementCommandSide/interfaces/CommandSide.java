package de.puls.service.ChargingStationManagementCommandSide.interfaces;

import de.puls.domain.ChargingStationManagement.CreateParkingAreaCommand;
import de.puls.domain.ChargingStationManagement.UpdateParkingAreaCommand;

public class CommandSide {

    public void createParkingArea(CreateParkingAreaCommand command) {
        checkRequiredParametersOfCreateParkingArea(command);
    }

    private void checkRequiredParametersOfCreateParkingArea(CreateParkingAreaCommand command) {
        if (command == null)
            throw new IllegalArgumentException("Required parameter \"command\" must not be null");
    }

    public void updateParkingArea(Long id, UpdateParkingAreaCommand command) {
        checkRequiredParametersOfUpdateParkingArea(id, command);
    }

    private void checkRequiredParametersOfUpdateParkingArea(Long id, UpdateParkingAreaCommand command) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
        if (command == null)
            throw new IllegalArgumentException("Required parameter \"command\" must not be null");
    }

    public void deleteParkingArea(Long id) {
        checkRequiredParametersOfDeleteParkingArea(id);
    }

    private void checkRequiredParametersOfDeleteParkingArea(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
    }

    public void sendParkingAreaCreatedEvent() {
    // TODO Method should asynchronously return one or more instances of SendParkingAreaCreatedEventAsyncResult
    }

    public void sendParkingAreaUpdatedEvent() {
    // TODO Method should asynchronously return one or more instances of SendParkingAreaUpdatedEventAsyncResult
    }

    public void sendParkingAreaDeletedEvent() {
    // TODO Method should asynchronously return one or more instances of SendParkingAreaDeletedEventAsyncResult
    }
}
