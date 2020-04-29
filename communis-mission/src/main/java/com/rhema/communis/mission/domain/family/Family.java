package com.rhema.communis.mission.domain.family;

import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "family")
public class Family extends BaseEntity {

    private String name;

    private List<FamilyMember> members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FamilyMember> getMembers() {
        return members;
    }

    public void setMembers(List<FamilyMember> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Family{" +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
