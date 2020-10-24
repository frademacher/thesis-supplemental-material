package de.puls.service.ChargingStationManagementCommandSide.interfaces;

import de.puls.domain.ChargingStationManagement.CreateParkingAreaCommand;
import de.puls.domain.ChargingStationManagement.UpdateParkingAreaCommand;
import de.puls.service.ChargingStationManagementCommandSide.interfaces.gen.CommandSideGen;

public class CommandSide implements CommandSideGen {

    @Override
    public void createParkingArea(CreateParkingAreaCommand command) {
        checkRequiredParametersOfCreateParkingArea(command);
    }

    private void checkRequiredParametersOfCreateParkingArea(CreateParkingAreaCommand command) {
        if (command == null)
            throw new IllegalArgumentException("Required parameter \"command\" must not be null");
    }

    @Override
    public void updateParkingArea(Long id, UpdateParkingAreaCommand command) {
        checkRequiredParametersOfUpdateParkingArea(id, command);
    }

    private void checkRequiredParametersOfUpdateParkingArea(Long id, UpdateParkingAreaCommand command) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
        if (command == null)
            throw new IllegalArgumentException("Required parameter \"command\" must not be null");
    }

    @Override
    public void deleteParkingArea(Long id) {
        checkRequiredParametersOfDeleteParkingArea(id);
    }

    private void checkRequiredParametersOfDeleteParkingArea(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
    }

    @Override
    public void sendParkingAreaCreatedEvent() {
        /*TODO Method should asynchronously return one or more instances of SendParkingAreaCreatedEventAsyncResult
 FIXME If you safely want to implement this method, create an extension interface called 
CommandSideExt in the same folder as this class file and run the code 
generator again. Otherwise, this file and all your changes to it will probably get overwritten 
the next time the code generator is executed. */
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void sendParkingAreaUpdatedEvent() {
        /*TODO Method should asynchronously return one or more instances of SendParkingAreaUpdatedEventAsyncResult
 FIXME If you safely want to implement this method, create an extension interface called 
CommandSideExt in the same folder as this class file and run the code 
generator again. Otherwise, this file and all your changes to it will probably get overwritten 
the next time the code generator is executed. */
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void sendParkingAreaDeletedEvent() {
        /*TODO Method should asynchronously return one or more instances of SendParkingAreaDeletedEventAsyncResult
 FIXME If you safely want to implement this method, create an extension interface called 
CommandSideExt in the same folder as this class file and run the code 
generator again. Otherwise, this file and all your changes to it will probably get overwritten 
the next time the code generator is executed. */
        throw new UnsupportedOperationException("Not implemented");
    }
}
