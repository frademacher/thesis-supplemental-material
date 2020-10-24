package de.puls.domain.ChargingStationManagement.gen;

public abstract class ParkingAreaDeletedEventGenImpl implements ParkingAreaDeletedEventGen {

    public ParkingAreaDeletedEventGenImpl() {
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

    public ParkingAreaDeletedEventGenImpl(long parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }
}
