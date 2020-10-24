package de.puls.service.ChargingStationManagementCommandSide.interfaces.operations.CommandSide.sendParkingAreaUpdatedEvent;

import de.puls.domain.ChargingStationManagement.ParkingAreaUpdatedEvent;

public class SendParkingAreaUpdatedEventAsyncResult {

    private ParkingAreaUpdatedEvent event;

    public ParkingAreaUpdatedEvent getEvent() {
        return event;
    }

    public void setEvent(ParkingAreaUpdatedEvent event) {
        this.event = event;
    }
}
