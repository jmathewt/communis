package com.rhema.communis.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address extends BaseEntity {
    private String street;
    private String street2;
    private String city;
    private String state;
    private String country;
    private boolean primary;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (primary != address.primary) return false;
        if (!street.equals(address.street)) return false;
        if (street2 != null ? !street2.equals(address.street2) : address.street2 != null) return false;
        if (!city.equals(address.city)) return false;
        if (!state.equals(address.state)) return false;
        return country.equals(address.country);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + (street2 != null ? street2.hashCode() : 0);
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + (primary ? 1 : 0);
        return result;
    }
}