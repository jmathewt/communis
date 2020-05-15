package com.rhema.communis.mission.domain.person;

import com.rhema.communis.domain.users.Person;
import com.rhema.communis.mission.domain.family.Family;
import com.rhema.communis.mission.domain.media.Photo;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "member")
@TypeAlias("member")
public class Member extends Person {

    @Id
    public String id;
    @DBRef
    private Family family;
    private String testimony;

    @DBRef
    private List<Photo> photos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getTestimony() {
        return testimony;
    }

    public void setTestimony(String testimony) {
        this.testimony = testimony;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Member{" +
                "family=" + family +
                ", testimony='" + testimony + '\'' +
                ", photos=" + photos +
                ", id='" + id + '\'' +
                '}';
    }
}
