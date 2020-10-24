package de.puls.domain.ChargingStationManagement.gen;

import de.fhdo.lemma.ddd.structure.DddValueObject;
import java.util.Date;

public abstract class TimePeriodGenImpl implements DddValueObject, TimePeriodGen {

    public TimePeriodGenImpl() {
    }

    protected Date start;

    @Override
    public Date getStart() {
        return start;
    }

    @Override
    public void setStart(Date start) {
        this.start = start;
    }

    protected Date end;

    @Override
    public Date getEnd() {
        return end;
    }

    @Override
    public void setEnd(Date end) {
        this.end = end;
    }

    public TimePeriodGenImpl(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
}
