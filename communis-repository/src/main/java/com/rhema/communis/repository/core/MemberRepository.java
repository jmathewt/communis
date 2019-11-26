package com.rhema.communis.repository.core;

import com.rhema.communis.domain.users.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Person, String> {
}
