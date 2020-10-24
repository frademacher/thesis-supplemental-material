package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.domain.ChargingStationManagement.gen.CreateParkingAreaCommandGen;

public class CreateParkingAreaCommand implements DddValueObject, CreateParkingAreaCommandGen {

    public CreateParkingAreaCommand() {
    }

    private ParkingAreaInformation info;

    @Override
    public ParkingAreaInformation getInfo() {
        return info;
    }

    public CreateParkingAreaCommand(ParkingAreaInformation info) {
        this.info = info;
    }
}
