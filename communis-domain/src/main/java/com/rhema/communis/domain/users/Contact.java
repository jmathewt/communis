package com.rhema.communis.domain.users;

import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contact extends BaseEntity {

    private ContactType type;
    private String value;
    private boolean primary;

    public Contact(ContactType type, String value, boolean primary) {
        this.type = type;
        this.value = value;
        this.primary = primary;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}
