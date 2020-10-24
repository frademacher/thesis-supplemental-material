package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;

public class CreateParkingAreaCommand implements DddValueObject {

    public CreateParkingAreaCommand() {
    }

    private ParkingAreaInformation info;

    public ParkingAreaInformation getInfo() {
        return info;
    }

    public CreateParkingAreaCommand(ParkingAreaInformation info) {
        this.info = info;
    }
}
