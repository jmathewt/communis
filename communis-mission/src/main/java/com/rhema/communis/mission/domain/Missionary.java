package com.rhema.communis.mission.domain;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.users.Person;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
public class Missionary<T extends Ministry> extends Person {
    private MissionaryType type;
    private Address missionStation;
    private String fatherName;
    private String motherName;
    private Integer numberOfChildren;
    private String testimony;
    private String otherDetails1;
    private String otherDetails2;
    private String otherDetails3;
    private String otherDetails4;
    private String otherDetails5;
    private List<T> ministries;
    @Indexed(name = "mission_missionary_region_idx")
    private String region;

}
