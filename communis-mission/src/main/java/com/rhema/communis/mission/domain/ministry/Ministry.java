package com.rhema.communis.mission.domain.ministry;

import com.rhema.communis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@Document
public class Ministry extends BaseEntity {

    Set<Incumbency> incumbents;
    @NotNull
    private MinistryType ministryType;
    @NotNull
    private Frequency frequency;
    @NotNull
    private DayOfWeek dayOfWeek;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;

}
