package com.rhema.communis.security;

import com.rhema.communis.security.model.Identity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Identity, String> {
    Identity findByUsername(String username);
}
