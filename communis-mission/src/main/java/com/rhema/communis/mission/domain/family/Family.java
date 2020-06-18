package com.rhema.communis.mission.domain.family;

import lombok.Getter;
import lombok.Setter;
import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "family")
@TypeAlias("family")
@Getter
@Setter
public class Family extends BaseEntity {

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
