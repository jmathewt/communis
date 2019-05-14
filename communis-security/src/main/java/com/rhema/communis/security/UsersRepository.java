package com.rhema.communis.security;

import com.rhema.communis.security.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
