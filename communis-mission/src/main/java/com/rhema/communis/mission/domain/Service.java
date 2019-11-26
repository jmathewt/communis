package com.rhema.communis.mission.domain;

import java.util.List;

public class Service extends Ministry {

    private ServiceType serviceType;
    private List<ServiceTiming> serviceTimings;

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<ServiceTiming> getServiceTimings() {
        return serviceTimings;
    }

    public void setServiceTimings(List<ServiceTiming> serviceTimings) {
        this.serviceTimings = serviceTimings;
    }

    @Override
    public MinistryType getType() {
        return MinistryType.SERVICE;
    }
}
