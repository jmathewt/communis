package com.rhema.communis.mission.domain.region;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Document
public class Region extends BaseEntity {
    @NotBlank
    private String organization;
    @Indexed(name = "mission_region_name_idx")
    @NotBlank

    private String name;
    @NotNull
    private RegionTier tier;
    @DBRef
    @NotNull
    private Address address;
    private String parentRegion;
    private Set<String> subRegions = new HashSet<>();

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getParentRegion() {
        return parentRegion;
    }

    public void setParentRegion(String parentRegion) {
        this.parentRegion = parentRegion;
    }

    public Set<String> getSubRegions() {
        return subRegions;
    }

    public void setSubRegions(Set<String> subRegions) {
        this.subRegions = subRegions;
    }
}
