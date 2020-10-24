package de.puls.domain.ChargingStationManagement;

public class ParkingAreaUpdatedEvent {

    public ParkingAreaUpdatedEvent() {
    }

    private long parkingAreaId;

    public long getParkingAreaId() {
        return parkingAreaId;
    }

    public void setParkingAreaId(long parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }

    private ParkingAreaInformation info;

    public ParkingAreaInformation getInfo() {
        return info;
    }

    public ParkingAreaUpdatedEvent(long parkingAreaId, ParkingAreaInformation info) {
        this.parkingAreaId = parkingAreaId;
        this.info = info;
    }
}
