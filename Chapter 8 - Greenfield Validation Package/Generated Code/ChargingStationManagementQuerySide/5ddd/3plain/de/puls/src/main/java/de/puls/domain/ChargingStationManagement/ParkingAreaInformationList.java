package de.puls.domain.ChargingStationManagement;

import java.util.ArrayList;

public class ParkingAreaInformationList extends ArrayList<ParkingAreaInformationList.ParkingAreaInformationListItem> {

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
