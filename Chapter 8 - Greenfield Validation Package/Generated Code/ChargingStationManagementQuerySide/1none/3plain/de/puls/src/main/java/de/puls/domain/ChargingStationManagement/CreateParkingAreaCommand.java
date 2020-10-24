package de.puls.domain.ChargingStationManagement;

public class CreateParkingAreaCommand {

    public CreateParkingAreaCommand() {
    }

    private ParkingAreaInformation info;

    public ParkingAreaInformation getInfo() {
        return info;
    }

    public CreateParkingAreaCommand(ParkingAreaInformation info) {
        this.info = info;
    }
}
