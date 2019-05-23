package com.rhema.communis.repository.core;

import com.rhema.communis.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
