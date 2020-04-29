package com.rhema.communis.mission.domain;

import com.rhema.communis.domain.BaseEntity;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "photo")
public class Photo extends BaseEntity {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    private String title;

    private Binary image;

    @Override
    public String toString() {
        return "Photo{" +
                "title='" + title + '\'' +
                ", image=" + image +
                '}';
    }
}
