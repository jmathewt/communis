package com.rhema.communis.mission.domain.family;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "family")
@TypeAlias("family")
@Getter
@Setter
public class Family {

    @Id
    private String id;

    @Indexed(name = "family_idx")
    private String name;

    private Set<FamilyMember> members;

    @Override
    public String toString() {
        return "Family{" +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
