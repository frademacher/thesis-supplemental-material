package de.puls.service.ChargingStationManagementCommandSide.interfaces.operations.CommandSide.sendParkingAreaUpdatedEvent;

import de.puls.domain.ChargingStationManagement.ParkingAreaUpdatedEvent;
import de.puls.service.ChargingStationManagementCommandSide.interfaces.operations.CommandSide.sendParkingAreaUpdatedEvent.gen.SendParkingAreaUpdatedEventAsyncResultGen;

public class SendParkingAreaUpdatedEventAsyncResult implements SendParkingAreaUpdatedEventAsyncResultGen {

    private ParkingAreaUpdatedEvent event;

    @Override
    public ParkingAreaUpdatedEvent getEvent() {
        return event;
    }

    @Override
    public void setEvent(ParkingAreaUpdatedEvent event) {
        this.event = event;
    }
}
