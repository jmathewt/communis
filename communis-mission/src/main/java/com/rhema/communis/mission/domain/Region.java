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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CountryCode getCountry() {
        return country;
    }

    public void setCountry(CountryCode country) {
        this.country = country;
    }

    public Set<Region> getSubRegions() {
        return subRegions;
    }

    public void setSubRegions(Set<Region> subRegions) {
        this.subRegions = subRegions;
    }
}
