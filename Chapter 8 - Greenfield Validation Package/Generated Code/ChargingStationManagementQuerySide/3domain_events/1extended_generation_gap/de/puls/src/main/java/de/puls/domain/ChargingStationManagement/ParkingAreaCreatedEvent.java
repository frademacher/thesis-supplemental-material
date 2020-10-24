package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.ParkingAreaCreatedEventGen;

public class ParkingAreaCreatedEvent implements ParkingAreaCreatedEventGen {

    public ParkingAreaCreatedEvent() {
    }

    private long parkingAreaId;

    @Override
    public long getParkingAreaId() {
        return parkingAreaId;
    }

    @Override
    public void setParkingAreaId(long parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }

    private ParkingAreaInformation info;

    @Override
    public ParkingAreaInformation getInfo() {
        return info;
    }

    public ParkingAreaCreatedEvent(long parkingAreaId, ParkingAreaInformation info) {
        this.parkingAreaId = parkingAreaId;
        this.info = info;
    }
}
