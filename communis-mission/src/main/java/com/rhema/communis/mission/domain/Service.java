package com.rhema.communis.mission.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Service extends Ministry {

    private ServiceType serviceType;
    private List<ServiceTiming> serviceTimings;

    @Override
    public MinistryType getType() {
        return MinistryType.SERVICE;
    }
}
