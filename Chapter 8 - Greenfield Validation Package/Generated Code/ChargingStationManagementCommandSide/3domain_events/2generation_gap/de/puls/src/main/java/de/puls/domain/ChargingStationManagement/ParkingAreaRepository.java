package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.ParkingAreaRepositoryGenImpl;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends ParkingAreaRepositoryGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
public class ParkingAreaRepository extends ParkingAreaRepositoryGenImpl {

    public ParkingAreaRepository() {
        super();
    }

    public ParkingAreaRepository(ParkingAreas managedParkingAreas) {
        super(managedParkingAreas);
    }
}
