package de.puls.domain.ChargingStationManagement.gen;

import de.fhdo.lemma.ddd.structure.DddFactory;
import de.puls.domain.ChargingStationManagement.ParkingArea;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;

public abstract class ParkingAreaFactoryGenImpl implements DddFactory, ParkingAreaFactoryGen {

    public ParkingAreaFactoryGenImpl() {
    }

    static public ParkingArea fromParkingAreaInformation(ParkingAreaInformation info) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
