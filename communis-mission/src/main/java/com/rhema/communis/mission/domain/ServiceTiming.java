package com.rhema.communis.mission.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
public class ServiceTiming {

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

}
