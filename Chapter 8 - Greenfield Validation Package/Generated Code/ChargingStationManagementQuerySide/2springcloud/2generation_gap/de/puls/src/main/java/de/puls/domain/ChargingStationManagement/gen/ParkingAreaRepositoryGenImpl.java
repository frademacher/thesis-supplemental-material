package de.puls.domain.ChargingStationManagement.gen;

import de.puls.domain.ChargingStationManagement.ParkingAreas;
import org.springframework.stereotype.Repository;

@Repository()
public abstract class ParkingAreaRepositoryGenImpl implements ParkingAreaRepositoryGen {

    public ParkingAreaRepositoryGenImpl() {
    }

    protected ParkingAreas managedParkingAreas;

    @Override
    public ParkingAreas getManagedParkingAreas() {
        return managedParkingAreas;
    }

    @Override
    public void setManagedParkingAreas(ParkingAreas managedParkingAreas) {
        this.managedParkingAreas = managedParkingAreas;
    }

    public ParkingAreaRepositoryGenImpl(ParkingAreas managedParkingAreas) {
        this.managedParkingAreas = managedParkingAreas;
    }
}
