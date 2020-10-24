package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.ParkingAreaRepositoryGen;
import org.springframework.stereotype.Repository;

@Repository()
public class ParkingAreaRepository implements ParkingAreaRepositoryGen {

    public ParkingAreaRepository() {
    }

    private ParkingAreas managedParkingAreas;

    @Override
    public ParkingAreas getManagedParkingAreas() {
        return managedParkingAreas;
    }

    @Override
    public void setManagedParkingAreas(ParkingAreas managedParkingAreas) {
        this.managedParkingAreas = managedParkingAreas;
    }

    public ParkingAreaRepository(ParkingAreas managedParkingAreas) {
        this.managedParkingAreas = managedParkingAreas;
    }
}
