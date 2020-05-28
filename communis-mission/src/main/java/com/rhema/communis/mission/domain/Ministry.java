package com.rhema.communis.mission.domain;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Ministry extends BaseEntity {
    private MinistryType type;
    private Address address;
    private Long attendees;

    public abstract MinistryType getType();
}
