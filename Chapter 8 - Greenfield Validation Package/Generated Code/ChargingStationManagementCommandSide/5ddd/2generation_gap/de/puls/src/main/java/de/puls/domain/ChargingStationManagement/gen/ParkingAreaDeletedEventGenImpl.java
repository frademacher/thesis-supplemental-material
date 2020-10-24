package de.puls.domain.ChargingStationManagement.gen;

import de.fhdo.lemma.ddd.structure.DddDomainEvent;
import de.fhdo.lemma.ddd.structure.DddValueObject;

public abstract class ParkingAreaDeletedEventGenImpl implements DddDomainEvent, DddValueObject, ParkingAreaDeletedEventGen {

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
