package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddDomainEvent;
import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.domain.ChargingStationManagement.gen.ParkingAreaUpdatedEventGen;

public class ParkingAreaUpdatedEvent implements DddDomainEvent, DddValueObject, ParkingAreaUpdatedEventGen {

    public ParkingAreaUpdatedEvent() {
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

    public ParkingAreaUpdatedEvent(long parkingAreaId, ParkingAreaInformation info) {
        this.parkingAreaId = parkingAreaId;
        this.info = info;
    }
}
