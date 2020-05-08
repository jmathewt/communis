package com.rhema.communis.mission.domain.ministry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalTime;
import java.util.List;

public class Ministry {

    @JsonProperty("_id")
    private String id;

    private MinistryType ministryType;

    private Frequency frequency;

    private String dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    List<Incumbency> incumbents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MinistryType getMinistryType() {
        return ministryType;
    }

    public void setMinistryType(MinistryType ministryType) {
        this.ministryType = ministryType;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
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

    public List<Incumbency> getIncumbents() {
        return incumbents;
    }

    public void setIncumbents(List<Incumbency> incumbents) {
        this.incumbents = incumbents;
    }
}
