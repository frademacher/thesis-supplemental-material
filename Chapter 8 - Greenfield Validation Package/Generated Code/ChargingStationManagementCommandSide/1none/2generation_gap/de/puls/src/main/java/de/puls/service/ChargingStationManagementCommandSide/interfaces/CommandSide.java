package de.puls.service.ChargingStationManagementCommandSide.interfaces;

import de.puls.domain.ChargingStationManagement.CreateParkingAreaCommand;
import de.puls.domain.ChargingStationManagement.UpdateParkingAreaCommand;
import de.puls.service.ChargingStationManagementCommandSide.interfaces.gen.CommandSideGenImpl;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends CommandSideGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
public class CommandSide extends CommandSideGenImpl {

    @Override
    public void createParkingArea(CreateParkingAreaCommand command) {
        checkRequiredParametersOfCreateParkingArea(command);
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        super.createParkingArea(command);
    }

    @Override
    public void updateParkingArea(Long id, UpdateParkingAreaCommand command) {
        checkRequiredParametersOfUpdateParkingArea(id, command);
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        super.updateParkingArea(id, command);
    }

    @Override
    public void deleteParkingArea(Long id) {
        checkRequiredParametersOfDeleteParkingArea(id);
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        super.deleteParkingArea(id);
    }

    @Override
    public void sendParkingAreaCreatedEvent() {
        /*TODO Method should asynchronously return one or more instances of SendParkingAreaCreatedEventAsyncResult
 TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.*/
        super.sendParkingAreaCreatedEvent();
    }

    @Override
    public void sendParkingAreaUpdatedEvent() {
        /*TODO Method should asynchronously return one or more instances of SendParkingAreaUpdatedEventAsyncResult
 TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.*/
        super.sendParkingAreaUpdatedEvent();
    }

    @Override
    public void sendParkingAreaDeletedEvent() {
        /*TODO Method should asynchronously return one or more instances of SendParkingAreaDeletedEventAsyncResult
 TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.*/
        super.sendParkingAreaDeletedEvent();
    }

    public CommandSide() {
    }
}
