package com.rhema.communis.mission.domain.family;

public class FamilyMember {

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String id) {
        this.personId = id;
    }

    public FamilyMemberType getRelationship() {
        return relationship;
    }

    public void setRelationship(FamilyMemberType relationship) {
        this.relationship = relationship;
    }

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
