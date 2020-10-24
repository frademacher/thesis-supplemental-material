package de.puls.service.ChargingStationManagementCommandSide.interfaces.operations.CommandSide.sendParkingAreaDeletedEvent.gen;

import de.puls.domain.ChargingStationManagement.ParkingAreaDeletedEvent;

public abstract class SendParkingAreaDeletedEventAsyncResultGenImpl implements SendParkingAreaDeletedEventAsyncResultGen {

    protected ParkingAreaDeletedEvent event;

    @Override
    public ParkingAreaDeletedEvent getEvent() {
        return event;
    }

    @Override
    public void setEvent(ParkingAreaDeletedEvent event) {
        this.event = event;
    }
}
