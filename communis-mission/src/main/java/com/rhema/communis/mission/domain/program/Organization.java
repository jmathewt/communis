package com.rhema.communis.mission.domain.program;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rhema.communis.domain.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "organization")
public class Organization {

    @Id
    @JsonProperty("_id")
    private String name;

    @DBRef
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
