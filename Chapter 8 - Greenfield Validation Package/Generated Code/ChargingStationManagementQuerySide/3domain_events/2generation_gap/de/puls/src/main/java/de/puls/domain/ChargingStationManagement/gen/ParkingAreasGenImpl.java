package de.puls.domain.ChargingStationManagement.gen;

import de.puls.domain.ChargingStationManagement.ParkingArea;
import java.util.ArrayList;

public abstract class ParkingAreasGenImpl extends ArrayList<ParkingAreasGenImpl.ParkingAreasItem> implements ParkingAreasGen {

    public static class ParkingAreasItem {

        public ParkingAreasItem() {
        }

        private ParkingArea p;

        public ParkingArea getP() {
            return p;
        }

        public void setP(ParkingArea p) {
            this.p = p;
        }

        public ParkingAreasItem(ParkingArea p) {
            this.p = p;
        }
    }
}
