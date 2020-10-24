package de.puls.domain.ChargingStationManagement;

public class ParkingAreaDeletedEvent {

    public ParkingAreaDeletedEvent() {
    }

    private long parkingAreaId;

    public long getParkingAreaId() {
        return parkingAreaId;
    }

    public void setParkingAreaId(long parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }

    public ParkingAreaDeletedEvent(long parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }
}
