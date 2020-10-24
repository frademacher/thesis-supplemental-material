package de.puls.service.ChargingStationManagementCommandSide.interfaces.operations.CommandSide.sendParkingAreaDeletedEvent;

import de.puls.domain.ChargingStationManagement.ParkingAreaDeletedEvent;
import de.puls.service.ChargingStationManagementCommandSide.interfaces.operations.CommandSide.sendParkingAreaDeletedEvent.gen.SendParkingAreaDeletedEventAsyncResultGen;

public class SendParkingAreaDeletedEventAsyncResult implements SendParkingAreaDeletedEventAsyncResultGen {

    private ParkingAreaDeletedEvent event;

    @Override
    public ParkingAreaDeletedEvent getEvent() {
        return event;
    }

    @Override
    public void setEvent(ParkingAreaDeletedEvent event) {
        this.event = event;
    }
}
