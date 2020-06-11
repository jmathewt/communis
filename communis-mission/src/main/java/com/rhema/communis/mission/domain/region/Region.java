package com.rhema.communis.mission.domain.region;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Document
@Getter
@Setter
public class Region extends BaseEntity {
    @NotEmpty
    private String organization;
    @Indexed(name = "mission_region_name_idx")
    @NotEmpty
    private String name;
    @NotNull
    private RegionTier tier;
    @DBRef
    @NotNull
    private Address address;
    private String parentRegion;
    private Set<String> subRegions = new HashSet<>();

}
