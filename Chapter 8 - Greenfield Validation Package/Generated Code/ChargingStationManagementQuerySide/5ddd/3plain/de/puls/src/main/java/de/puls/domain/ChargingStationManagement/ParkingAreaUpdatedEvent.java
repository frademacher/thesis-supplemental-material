package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddDomainEvent;
import de.fhdo.lemma.ddd.structure.DddValueObject;

public class ParkingAreaUpdatedEvent implements DddDomainEvent, DddValueObject {

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
