package com.rhema.communis.mission.family;

import com.rhema.communis.mission.domain.family.Family;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyRepository extends MongoRepository<Family, String> {

}
