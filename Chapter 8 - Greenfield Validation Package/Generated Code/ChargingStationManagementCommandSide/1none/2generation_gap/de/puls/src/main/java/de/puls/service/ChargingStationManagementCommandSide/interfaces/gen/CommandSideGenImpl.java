package de.puls.service.ChargingStationManagementCommandSide.interfaces.gen;

import de.puls.domain.ChargingStationManagement.CreateParkingAreaCommand;
import de.puls.domain.ChargingStationManagement.UpdateParkingAreaCommand;

public abstract class CommandSideGenImpl implements CommandSideGen {

    @Override
    public void createParkingArea(CreateParkingAreaCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void checkRequiredParametersOfCreateParkingArea(CreateParkingAreaCommand command) {
        if (command == null)
            throw new IllegalArgumentException("Required parameter \"command\" must not be null");
    }

    @Override
    public void updateParkingArea(Long id, UpdateParkingAreaCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void checkRequiredParametersOfUpdateParkingArea(Long id, UpdateParkingAreaCommand command) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
        if (command == null)
            throw new IllegalArgumentException("Required parameter \"command\" must not be null");
    }

    @Override
    public void deleteParkingArea(Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void checkRequiredParametersOfDeleteParkingArea(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
    }

    @Override
    public void sendParkingAreaCreatedEvent() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void sendParkingAreaUpdatedEvent() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void sendParkingAreaDeletedEvent() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
