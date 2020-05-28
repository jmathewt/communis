package com.rhema.communis.mission.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neovisionaries.i18n.CountryCode;
import com.rhema.communis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document
@Getter
@Setter
public class Region extends BaseEntity {
    @Indexed(name = "mission_region_name_idx")
    private String missionRegionName;
    private String state;
    private CountryCode country;
    private RegionTier tier;
    @DBRef
    private Set<Sponsor> sponsors = new HashSet<>();
    private String parentRegion;
    @JsonIgnore
    private Set<String> subRegions = new HashSet<>();

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
