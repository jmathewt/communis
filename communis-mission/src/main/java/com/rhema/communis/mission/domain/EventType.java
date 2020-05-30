package com.rhema.communis.mission.domain;

import com.rhema.communis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter

public class EventType extends BaseEntity {

    @Indexed(unique = true)
    private String eventName;
    private String description;
    private boolean active;

}
