package com.rhema.communis.mission.domain.ministry;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class Incumbency {

    private String personId;
    private Boolean active = true;
    private LocalDate from;
    private LocalDate to;

    @Override
    public String toString() {
        return "Incumbency{" +
                "personId='" + personId + '\'' +
                ", active=" + active +
                ", from=" + from +
                ", to=" + to +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Incumbency)) return false;
        Incumbency that = (Incumbency) o;
        return personId.equals(that.personId) &&
                active.equals(that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, active);
    }
}
