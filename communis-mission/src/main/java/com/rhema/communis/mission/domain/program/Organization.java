package com.rhema.communis.mission.domain.program;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhema.communis.domain.Address;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "organization")
@Getter
@Setter
public class Organization {

    @Id
    @JsonProperty("_id")
    private String name;

    @DBRef
    private Address address;

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
