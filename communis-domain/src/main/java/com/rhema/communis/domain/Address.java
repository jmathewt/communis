package com.rhema.communis.domain;

import com.neovisionaries.i18n.CountryCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Document
@CompoundIndexes({
        @CompoundIndex(name = "address_idx", def = "{'street' : 1, 'street2': 1, 'city': 1, 'state': 1, 'zipcode': 1, 'country': 1}", unique = true)
})
@Getter
@Setter
@TypeAlias("address")
public class Address extends BaseEntity {
    @NotBlank
    private String street;
    private String street2;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @Pattern(regexp = "^[0-9]*$")
    private String zipcode;
    @NotNull
    private CountryCode country;
    private boolean primary = true;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (primary != address.primary) return false;
        if (!street.equals(address.street)) return false;
        if (street2 != null ? !street2.equals(address.street2) : address.street2 != null) return false;
        if (!city.equals(address.city)) return false;
        if (!zipcode.equals(address.zipcode)) return false;
        if (!state.equals(address.state)) return false;
        return country.equals(address.country);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + (street2 != null ? street2.hashCode() : 0);
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + zipcode.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + (primary ? 1 : 0);
        return result;
    }
}
