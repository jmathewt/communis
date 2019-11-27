package com.rhema.communis.mission.region;

import com.rhema.communis.mission.domain.Region;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends MongoRepository<Region, String> {
}
