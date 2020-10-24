package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.UpdateParkingAreaCommandGen;

public class UpdateParkingAreaCommand implements UpdateParkingAreaCommandGen {

    public UpdateParkingAreaCommand() {
    }

    private ParkingAreaInformation info;

    @Override
    public ParkingAreaInformation getInfo() {
        return info;
    }

    public UpdateParkingAreaCommand(ParkingAreaInformation info) {
        this.info = info;
    }
}
