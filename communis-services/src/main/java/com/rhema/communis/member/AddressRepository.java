package com.rhema.communis.member;

import com.rhema.communis.domain.Address;
import com.rhema.communis.mission.domain.person.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
