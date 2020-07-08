package com.rhema.communis.domain.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rhema.communis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact extends BaseEntity {

    private ContactType type;
    private String value;
    private boolean primary;

    public Contact(ContactType type, String value, boolean primary) {
        this.type = type;
        this.value = value;
        this.primary = primary;
    }
}
