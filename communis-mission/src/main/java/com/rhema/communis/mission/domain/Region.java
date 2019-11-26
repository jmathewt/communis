package com.rhema.communis.mission.domain;

import com.neovisionaries.i18n.CountryCode;
import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
public class Region extends BaseEntity {
    private String regionName;
    private String state;
    private CountryCode country;
    private Set<Region> subRegions;
}
