package com.rhema.communis.mission.domain.person;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.users.Person;
import com.rhema.communis.mission.domain.media.Photo;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * TODO: The class name must be fixed
 * */

@Document(collection = "person")
@TypeAlias("person")
public class PersonDerived extends Person {

    @DBRef
    private String familyId;
    private String testimony;

    @DBRef
    private List<Photo> photos;

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
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
        return "PersonDerived{" +
                "familyId='" + familyId + '\'' +
                ", testimony='" + testimony + '\'' +
                ", photos=" + photos +
                '}';
    }
}
