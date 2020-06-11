package com.rhema.communis.mission.organization;

import com.rhema.communis.mission.domain.program.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends MongoRepository<Organization, String> {

}
