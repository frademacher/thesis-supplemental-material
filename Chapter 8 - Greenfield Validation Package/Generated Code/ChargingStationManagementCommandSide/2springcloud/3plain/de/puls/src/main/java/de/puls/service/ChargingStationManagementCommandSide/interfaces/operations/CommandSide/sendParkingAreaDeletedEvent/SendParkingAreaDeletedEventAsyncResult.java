package de.puls.service.ChargingStationManagementCommandSide.interfaces.operations.CommandSide.sendParkingAreaDeletedEvent;

import de.puls.domain.ChargingStationManagement.ParkingAreaDeletedEvent;

public class SendParkingAreaDeletedEventAsyncResult {

    private ParkingAreaDeletedEvent event;

    public ParkingAreaDeletedEvent getEvent() {
        return event;
    }

    public void setEvent(ParkingAreaDeletedEvent event) {
        this.event = event;
    }
}
