package com.rhema.communis.person;

import com.rhema.communis.mission.domain.person.PersonDerived;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<PersonDerived, String> {
}
