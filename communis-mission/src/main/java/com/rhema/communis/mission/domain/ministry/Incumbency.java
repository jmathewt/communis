package com.rhema.communis.mission.domain.ministry;

import java.time.LocalDate;

public class Incumbency {

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public MinistryType getMinistryType() {
        return ministryType;
    }

    public void setMinistryType(MinistryType ministryType) {
        this.ministryType = ministryType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    private String personId;
    private MinistryType ministryType;
    private Boolean active;
    private LocalDate from;
    private LocalDate to;

    @Override
    public String toString() {
        return "Incumbency{" +
                "personId='" + personId + '\'' +
                ", ministryType=" + ministryType +
                ", active=" + active +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
