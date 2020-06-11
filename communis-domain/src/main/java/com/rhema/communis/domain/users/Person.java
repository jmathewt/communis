package com.rhema.communis.domain.users;

import com.rhema.communis.domain.Address;
import lombok.Getter;
import lombok.Setter;
import com.rhema.communis.domain.BaseEntity;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.Set;

@CompoundIndexes({
        @CompoundIndex(name = "member_idx", def = "{'firstName' : 1, 'lastName': 1, 'dateOfBirth': 1, 'identity': 1}", unique = true)
})
@Getter
@Setter
public class Person extends BaseEntity {

    @Indexed
    private String firstName;
    private String middleName;
    @Indexed
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Set<Contact> contacts;
    private boolean active;
    @DBRef
    private Set<Address> address;
    @Indexed
    private String identity;
}
