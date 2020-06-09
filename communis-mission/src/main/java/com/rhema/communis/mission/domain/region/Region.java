package com.rhema.communis.mission.domain.region;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.BaseEntity;
import com.rhema.communis.mission.domain.program.Organization;
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

}
