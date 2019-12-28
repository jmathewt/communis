package com.rhema.communis.mission.domain;

import com.neovisionaries.i18n.CountryCode;
import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Document
@CompoundIndexes({
        @CompoundIndex(name = "mission_region_idx", def = "{'missionRegionName' : 1, 'state': 1, 'country': 1}", unique = true)
})
public class Region extends BaseEntity {
    @Indexed(name = "mission_region_name_idx")
    private String missionRegionName;
    private String state;
    private CountryCode country;
    private Set<Region> subRegions;
    private List<String> sponsors = new ArrayList<>();

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

    public Set<Region> getSubRegions() {
        return subRegions;
    }

    public void setSubRegions(Set<Region> subRegions) {
        this.subRegions = subRegions;
    }

    public List<String> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<String> sponsors) {
        this.sponsors = sponsors;
    }
}
