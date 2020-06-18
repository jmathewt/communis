package com.rhema.communis.mission.domain.person;

import com.rhema.communis.domain.users.Person;
import com.rhema.communis.mission.domain.family.Family;
import com.rhema.communis.mission.domain.media.Photo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "member")
@TypeAlias("member")
@Getter
@Setter
public class Member extends Person {
    @DBRef
    private Family family;
    private String testimony;
    @DBRef
    private List<Photo> photos;

    @Override
    public String toString() {
        return "Member{" +
                "family=" + family +
                ", testimony='" + testimony + '\'' +
                ", photos=" + photos +
                '}';
    }
}
