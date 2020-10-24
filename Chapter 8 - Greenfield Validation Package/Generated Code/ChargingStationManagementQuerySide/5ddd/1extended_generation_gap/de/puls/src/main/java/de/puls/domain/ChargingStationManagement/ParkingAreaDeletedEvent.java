package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddDomainEvent;
import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.domain.ChargingStationManagement.gen.ParkingAreaDeletedEventGen;

public class ParkingAreaDeletedEvent implements DddDomainEvent, DddValueObject, ParkingAreaDeletedEventGen {

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
