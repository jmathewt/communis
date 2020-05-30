package com.rhema.communis.mission.domain.family;

import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "family")
@TypeAlias("family")
public class Family extends BaseEntity {

    @Indexed(name = "family_idx")
    private String name;

    private Set<FamilyMember> members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<FamilyMember> getMembers() {
        return members;
    }

    public void setMembers(Set<FamilyMember> members) {
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
