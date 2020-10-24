package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;

public class UpdateParkingAreaCommand implements DddValueObject {

    public UpdateParkingAreaCommand() {
    }

    private ParkingAreaInformation info;

    public ParkingAreaInformation getInfo() {
        return info;
    }

    public UpdateParkingAreaCommand(ParkingAreaInformation info) {
        this.info = info;
    }
}
