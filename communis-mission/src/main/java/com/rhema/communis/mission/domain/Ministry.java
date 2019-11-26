package com.rhema.communis.mission.domain;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.BaseEntity;

public abstract class Ministry extends BaseEntity {
    private MinistryType type;
    private Address address;
    private Long attendees;

    public abstract MinistryType getType();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getAttendees() {
        return attendees;
    }

    public void setAttendees(Long attendees) {
        this.attendees = attendees;
    }
}
