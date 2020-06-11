package com.rhema.communis.mission.domain.program;

import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document(collection = "organization")
@Getter
@Setter
public class Organization extends BaseEntity {

    @NotEmpty
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

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
