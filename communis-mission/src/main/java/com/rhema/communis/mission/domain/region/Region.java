package com.rhema.communis.mission.domain.region;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neovisionaries.i18n.CountryCode;
import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.BaseEntity;
import com.rhema.communis.mission.domain.Sponsor;
import com.rhema.communis.mission.domain.program.Organization;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document
public class Region extends BaseEntity {

    @DBRef
    private Organization organization;
    @Indexed(name = "mission_region_name_idx")
    private String name;
    private RegionTier tier;
    private Address address;
    @DBRef
    private Region parentRegion;
    @DBRef
    private Set<Region> subRegions = new HashSet<>();

    public Set<Region> getSubRegions() {
        return subRegions;
    }

    public void setSubRegions(Set<Region> subRegions) {
        this.subRegions = subRegions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionTier getTier() {
        return tier;
    }

    public void setTier(RegionTier tier) {
        this.tier = tier;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Region getParentRegion() {
        return parentRegion;
    }

    public void setParentRegion(Region parentRegion) {
        this.parentRegion = parentRegion;
    }

}
