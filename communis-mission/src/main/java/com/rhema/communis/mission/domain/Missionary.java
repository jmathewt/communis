package com.rhema.communis.mission.domain;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.users.Person;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
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
    private String region;

    public MissionaryType getType() {
        return type;
    }

    public void setType(MissionaryType type) {
        this.type = type;
    }

    public Address getMissionStation() {
        return missionStation;
    }

    public void setMissionStation(Address missionStation) {
        this.missionStation = missionStation;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public String getTestimony() {
        return testimony;
    }

    public void setTestimony(String testimony) {
        this.testimony = testimony;
    }

    public String getOtherDetails1() {
        return otherDetails1;
    }

    public void setOtherDetails1(String otherDetails1) {
        this.otherDetails1 = otherDetails1;
    }

    public String getOtherDetails2() {
        return otherDetails2;
    }

    public void setOtherDetails2(String otherDetails2) {
        this.otherDetails2 = otherDetails2;
    }

    public String getOtherDetails3() {
        return otherDetails3;
    }

    public void setOtherDetails3(String otherDetails3) {
        this.otherDetails3 = otherDetails3;
    }

    public String getOtherDetails4() {
        return otherDetails4;
    }

    public void setOtherDetails4(String otherDetails4) {
        this.otherDetails4 = otherDetails4;
    }

    public String getOtherDetails5() {
        return otherDetails5;
    }

    public void setOtherDetails5(String otherDetails5) {
        this.otherDetails5 = otherDetails5;
    }

    public List<T> getMinistries() {
        return ministries;
    }

    public void setMinistries(List<T> ministries) {
        this.ministries = ministries;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
