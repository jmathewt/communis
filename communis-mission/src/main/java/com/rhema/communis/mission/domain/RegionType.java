package com.rhema.communis.mission.domain;

import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RegionType extends BaseEntity {

    private String regionTypeName;

    public String getRegionTypeName() {
        return regionTypeName;
    }

    public void setRegionTypeName(String regionTypeName) {
        this.regionTypeName = regionTypeName;
    }
}
