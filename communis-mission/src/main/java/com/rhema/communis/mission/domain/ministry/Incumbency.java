package com.rhema.communis.mission.domain.ministry;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Incumbency {

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
