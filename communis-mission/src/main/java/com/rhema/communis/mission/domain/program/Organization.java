package com.rhema.communis.mission.domain.program;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document(collection = "organization")
public class Organization extends BaseEntity {

    @NotBlank
    private String name;
    @Valid
    @NotNull
    @DBRef
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        Organization that = (Organization) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

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
