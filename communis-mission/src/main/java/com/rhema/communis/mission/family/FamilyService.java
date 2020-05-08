package com.rhema.communis.mission.family;

import com.rhema.communis.common.AbstractService;
import com.rhema.communis.mission.domain.family.Family;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class FamilyService extends AbstractService<Family, String> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MongoRepository<Family, String> familyRepository;

    @Autowired
    public FamilyService(MongoRepository<Family, String> familyRepository){
        this.familyRepository = familyRepository;
    }
}
