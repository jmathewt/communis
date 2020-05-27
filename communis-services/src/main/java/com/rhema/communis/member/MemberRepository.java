package com.rhema.communis.member;

import com.rhema.communis.mission.domain.person.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}
