package com.rhema.communis.member;

import com.rhema.communis.mission.domain.person.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface MemberRepository extends MongoRepository<Member, String> {

    List<Member> findByFirstName(String firstName);

    List<Member> findByLastName(String lastName);

    List<Member> findByFirstNameAndLastName(String firstName, String lastName);

    List<Member> findByFirstNameOrLastName(String name);

}
