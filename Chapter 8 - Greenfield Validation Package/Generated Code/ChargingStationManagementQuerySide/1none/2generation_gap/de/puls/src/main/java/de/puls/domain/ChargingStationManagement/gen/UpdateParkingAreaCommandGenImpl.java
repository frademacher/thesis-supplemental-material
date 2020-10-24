package de.puls.domain.ChargingStationManagement.gen;

import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;

public abstract class UpdateParkingAreaCommandGenImpl implements UpdateParkingAreaCommandGen {

    public UpdateParkingAreaCommandGenImpl() {
    }

    protected ParkingAreaInformation info;

    @Override
    public ParkingAreaInformation getInfo() {
        return info;
    }

    public UpdateParkingAreaCommandGenImpl(ParkingAreaInformation info) {
        this.info = info;
    }
}
