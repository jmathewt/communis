package com.rhema.communis.mission.missionary;

import com.rhema.communis.mission.domain.Missionary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionaryRepository extends MongoRepository<Missionary, String> {
}
