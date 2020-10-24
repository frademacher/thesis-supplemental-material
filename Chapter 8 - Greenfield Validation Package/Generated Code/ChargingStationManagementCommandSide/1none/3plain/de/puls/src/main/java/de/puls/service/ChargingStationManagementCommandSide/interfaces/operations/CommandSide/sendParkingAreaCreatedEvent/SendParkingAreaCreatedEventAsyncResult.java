package de.puls.service.ChargingStationManagementCommandSide.interfaces.operations.CommandSide.sendParkingAreaCreatedEvent;

import de.puls.domain.ChargingStationManagement.ParkingAreaCreatedEvent;

public class SendParkingAreaCreatedEventAsyncResult {

    private ParkingAreaCreatedEvent event;

    public ParkingAreaCreatedEvent getEvent() {
        return event;
    }

    public void setEvent(ParkingAreaCreatedEvent event) {
        this.event = event;
    }
}
