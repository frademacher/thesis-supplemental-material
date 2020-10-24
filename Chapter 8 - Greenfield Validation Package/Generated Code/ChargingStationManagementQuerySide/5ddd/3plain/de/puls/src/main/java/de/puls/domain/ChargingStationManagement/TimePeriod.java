package de.puls.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;
import java.util.Date;

public class TimePeriod implements DddValueObject {

    public TimePeriod() {
    }

    private Date start;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    private Date end;

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public TimePeriod(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
}
