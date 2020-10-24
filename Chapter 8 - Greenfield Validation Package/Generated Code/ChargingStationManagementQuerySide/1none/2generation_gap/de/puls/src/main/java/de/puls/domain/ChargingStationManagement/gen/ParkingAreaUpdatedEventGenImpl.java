package de.puls.domain.ChargingStationManagement.gen;

import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;

public abstract class ParkingAreaUpdatedEventGenImpl implements ParkingAreaUpdatedEventGen {

    public ParkingAreaUpdatedEventGenImpl() {
    }

    protected long parkingAreaId;

    @Override
    public long getParkingAreaId() {
        return parkingAreaId;
    }

    @Override
    public void setParkingAreaId(long parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }

    protected ParkingAreaInformation info;

    @Override
    public ParkingAreaInformation getInfo() {
        return info;
    }

    public ParkingAreaUpdatedEventGenImpl(long parkingAreaId, ParkingAreaInformation info) {
        this.parkingAreaId = parkingAreaId;
        this.info = info;
    }
}
