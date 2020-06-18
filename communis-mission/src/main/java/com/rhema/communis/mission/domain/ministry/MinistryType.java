package com.rhema.communis.mission.domain.ministry;

import com.rhema.communis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ministryType")
@Getter
@Setter
public class MinistryType extends BaseEntity {

    private String name;
    private String description;

}
