package com.rhema.communis.mission.domain;

import com.neovisionaries.i18n.CountryCode;
import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document
public class Region extends BaseEntity {
    @Indexed(name = "mission_region_name_idx")
    private String missionRegionName;
    private String state;
    private CountryCode country;
    @DBRef
    private RegionType regionType;
    @DBRef
    private Set<Sponsor> sponsors = new HashSet<>();
    private String parentRegion;
    private Set<String> subRegions = new HashSet<>();

    public Set<String> getSubRegions() {
        return subRegions;
    }

    public void setSubRegions(Set<String> subRegions) {
        this.subRegions = subRegions;
    }

    public String getMissionRegionName() {
        return missionRegionName;
    }

    public void setMissionRegionName(String missionRegionName) {
        this.missionRegionName = missionRegionName;
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

    public RegionType getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionType regionType) {
        this.regionType = regionType;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(Set<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    public String getParentRegion() {
        return parentRegion;
    }

    public void setParentRegion(String parentRegion) {
        this.parentRegion = parentRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Region)) return false;

        Region region = (Region) o;

        if (!missionRegionName.equals(region.missionRegionName)) return false;
        if (!state.equals(region.state)) return false;
        return country == region.country;
    }

    @Override
    public int hashCode() {
        int result = missionRegionName.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }
}
