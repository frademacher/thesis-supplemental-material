package de.puls.domain.ChargingStationManagement;

import org.springframework.stereotype.Repository;

@Repository()
public class ParkingAreaRepository {

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
