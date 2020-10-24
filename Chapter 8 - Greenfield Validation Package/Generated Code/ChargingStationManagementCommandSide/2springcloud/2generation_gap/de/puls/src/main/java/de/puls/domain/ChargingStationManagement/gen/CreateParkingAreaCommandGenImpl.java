package de.puls.domain.ChargingStationManagement.gen;

import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;

public abstract class CreateParkingAreaCommandGenImpl implements CreateParkingAreaCommandGen {

    public CreateParkingAreaCommandGenImpl() {
    }

    protected ParkingAreaInformation info;

    @Override
    public ParkingAreaInformation getInfo() {
        return info;
    }

    public CreateParkingAreaCommandGenImpl(ParkingAreaInformation info) {
        this.info = info;
    }
}
