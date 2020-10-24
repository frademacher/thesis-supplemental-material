package de.puls.domain.ChargingStationManagement.gen;

import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;
import java.util.ArrayList;

public abstract class ParkingAreaInformationListGenImpl extends ArrayList<ParkingAreaInformationListGenImpl.ParkingAreaInformationListItem> implements ParkingAreaInformationListGen {

    public static class ParkingAreaInformationListItem {

        public ParkingAreaInformationListItem() {
        }

        private ParkingAreaInformation i;

        public ParkingAreaInformation getI() {
            return i;
        }

        public void setI(ParkingAreaInformation i) {
            this.i = i;
        }

        public ParkingAreaInformationListItem(ParkingAreaInformation i) {
            this.i = i;
        }
    }
}
