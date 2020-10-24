package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddRepository;
import org.springframework.stereotype.Repository;

@Repository()
public class ParkingAreaRepository implements DddRepository {

    public ParkingAreaRepository() {
    }

    private ParkingAreas managedParkingAreas;

    public ParkingAreas getManagedParkingAreas() {
        return managedParkingAreas;
    }

    public void setManagedParkingAreas(ParkingAreas managedParkingAreas) {
        this.managedParkingAreas = managedParkingAreas;
    }

    public ParkingAreaRepository(ParkingAreas managedParkingAreas) {
        this.managedParkingAreas = managedParkingAreas;
    }
}
