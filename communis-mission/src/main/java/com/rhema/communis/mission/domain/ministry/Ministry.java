package com.rhema.communis.mission.domain.ministry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class Ministry {

    @JsonProperty("_id")
    private String id;

    private MinistryType ministryType;

    private Frequency frequency;

    private String dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    List<Incumbency> incumbents;

}
