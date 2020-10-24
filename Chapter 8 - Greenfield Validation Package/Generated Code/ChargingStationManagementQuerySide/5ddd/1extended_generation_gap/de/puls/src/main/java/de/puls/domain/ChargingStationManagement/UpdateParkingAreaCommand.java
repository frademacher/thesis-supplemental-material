package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.domain.ChargingStationManagement.gen.UpdateParkingAreaCommandGen;

public class UpdateParkingAreaCommand implements DddValueObject, UpdateParkingAreaCommandGen {

    public UpdateParkingAreaCommand() {
    }

    private ParkingAreaInformation info;

    @Override
    public ParkingAreaInformation getInfo() {
        return info;
    }

    public UpdateParkingAreaCommand(ParkingAreaInformation info) {
        this.info = info;
    }
}
