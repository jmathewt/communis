package com.rhema.communis.mission.domain.media;

import com.rhema.communis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "photo")
@Getter
@Setter
public class Photo extends BaseEntity {

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
