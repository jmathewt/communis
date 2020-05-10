package com.rhema.communis.person;

import com.rhema.communis.common.AbstractService;
import com.rhema.communis.domain.Address;
import com.rhema.communis.member.AddressService;
import com.rhema.communis.mission.domain.person.PersonDerived;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService extends AbstractService<PersonDerived, String> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MongoRepository<PersonDerived, String> personRepository;
    private final AddressService addressService;

    @Autowired
    public PersonService(MongoRepository<PersonDerived, String> personRepository,
                         AddressService addressService){
        this.personRepository = personRepository;
        this.addressService = addressService;
    }

    public PersonDerived create(PersonDerived person){
        if(CollectionUtils.isNotEmpty(person.getAddress())){
            List<Address> createdAddresses = addressService.createAddresses(person.getAddress());
            person.setAddress(createdAddresses);
        }
        return saveOrUpdate(person);
    }

    @Transactional
    public PersonDerived update(PersonDerived person) {
        PersonDerived existingPerson = this.find(person.getId());
        if(existingPerson == null){
            throw new IllegalArgumentException("Person - " + person.getId() + " not found");
        }
        List<Address> personAddresses = addressService.checkAndCreateNonExistantAddresses(
                person.getAddress());
        if(CollectionUtils.isNotEmpty(personAddresses)){
            person.setAddress(personAddresses);
        }
        BeanUtils.copyProperties(person, existingPerson);
        return this.saveOrUpdate(existingPerson);
    }

}
