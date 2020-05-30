package com.rhema.communis.mission.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Event extends Ministry {

    private EventType type;
    private LocalDate localDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @Override
    public MinistryType getType() {
        return MinistryType.EVENT;
    }

}
