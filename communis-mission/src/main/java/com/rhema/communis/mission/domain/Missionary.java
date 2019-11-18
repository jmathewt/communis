package com.rhema.communis.mission.domain;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.users.User;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Missionary extends User {
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

}
