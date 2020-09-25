package com.rhema.communis.member;

import com.rhema.communis.mission.domain.person.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface MemberRepository extends MongoRepository<Member, String> {

    List<Member> findByFirstNameIgnoreCaseOrMiddleNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String middleName, String lastName);

    List<Member> findByFirstNameIgnoreCaseStartsWithAndMiddleNameIgnoreCaseStartsWithAndLastNameIgnoreCaseStartsWith(String firstName, String middleName, String lastName);

    List<Member> findByFirstNameIgnoreCaseStartsWithAndLastNameIgnoreCaseStartsWith(String firstName, String middleName, String lastName);

    List<Member> findByFirstNameIgnoreCaseAndMiddleNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String middleName, String lastName);

    List<Member> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

    List<Member> findByFirstNameIgnoreCaseStartsWithAndLastNameIgnoreCaseStartsWith(String firstName, String lastName);

    List<Member> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);

    List<Member> findByFirstNameIgnoreCase(String name);

    List<Member> findByMiddleNameIgnoreCaseOrLastNameIgnoreCase(String middleName, String lastName);

    List<Member> findByFirstNameIgnoreCaseStartsWithOrMiddleNameIgnoreCaseStartsWithOrLastNameIgnoreCaseStartsWith(String firstName,
                                                                                                                   String middleName,
                                                                                                                   String lastName);

}
