package com.rhema.communis.person;

import com.rhema.communis.common.AbstractService;
import com.rhema.communis.mission.domain.person.PersonDerived;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractService<PersonDerived, String> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MongoRepository<PersonDerived, String> personRepository;

    @Autowired
    public PersonService(MongoRepository<PersonDerived, String> personRepository){
        this.personRepository = personRepository;
    }

}
