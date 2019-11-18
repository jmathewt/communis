package com.rhema.communis.repository.core;

import com.rhema.communis.domain.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<User, String> {
}
