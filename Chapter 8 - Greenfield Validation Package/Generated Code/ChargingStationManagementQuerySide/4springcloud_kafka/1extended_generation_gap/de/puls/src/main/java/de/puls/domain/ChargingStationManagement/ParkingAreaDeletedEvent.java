package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.ParkingAreaDeletedEventGen;

public class ParkingAreaDeletedEvent implements ParkingAreaDeletedEventGen {

    public ParkingAreaDeletedEvent() {
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

    public ParkingAreaDeletedEvent(long parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }
}
