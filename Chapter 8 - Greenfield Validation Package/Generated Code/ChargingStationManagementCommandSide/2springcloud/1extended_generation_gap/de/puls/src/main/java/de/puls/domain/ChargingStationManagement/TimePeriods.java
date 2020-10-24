package de.puls.domain.ChargingStationManagement;

import de.puls.domain.ChargingStationManagement.gen.TimePeriodsGen;
import java.util.ArrayList;

public class TimePeriods extends ArrayList<TimePeriods.TimePeriodsItem> implements TimePeriodsGen {

    public static class TimePeriodsItem {

        public TimePeriodsItem() {
        }

        private TimePeriod p;

        public TimePeriod getP() {
            return p;
        }

        public void setP(TimePeriod p) {
            this.p = p;
        }

        public TimePeriodsItem(TimePeriod p) {
            this.p = p;
        }
    }
}
