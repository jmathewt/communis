package com.rhema.communis.mission.domain.family;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyMember {

    private String personId;

    private FamilyMemberType relationship;

    @Override
    public String toString() {
        return "FamilyMember{" +
                "personId='" + personId + '\'' +
                ", relationship=" + relationship +
                '}';
    }
}
