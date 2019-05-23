package com.rhema.communis.repository.core;

import com.rhema.communis.domain.users.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}
