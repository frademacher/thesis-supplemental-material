package de.puls.domain.ChargingStationManagement;

import java.util.ArrayList;

public class TimePeriods extends ArrayList<TimePeriods.TimePeriodsItem> {

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
