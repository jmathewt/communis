package com.rhema.communis.mission.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event extends Ministry {

    private EventType type;
    private LocalDate localDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public MinistryType getType() {
        return MinistryType.EVENT;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
