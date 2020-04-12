package com.rhema.communis.mission.region;

import com.rhema.communis.mission.domain.Region;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RegionRepository extends MongoRepository<Region, String> {
    @Query("{_id: { $in: ?0 } })")
    List<Region> findByIds(Set<String> ids);
}
