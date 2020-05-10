package com.rhema.communis.member;

import com.rhema.communis.common.AbstractService;
import com.rhema.communis.domain.Address;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService extends AbstractService<Address, String> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MongoRepository<Address, String> addressRepository;

    @Autowired
    public AddressService(MongoRepository<Address, String> addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<Address> checkAndCreateNonExistantAddresses(List<Address> addressesToCheck){
        if(CollectionUtils.isEmpty(addressesToCheck)){
            return Arrays.asList();
        }
        List<Address> nonExistingAddresses = addressesToCheck.stream()
                .filter(address -> StringUtils.isEmpty(address.getId()))
                .collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(nonExistingAddresses)){
            addressesToCheck.addAll(createAddresses(nonExistingAddresses));
        }
        List<Address> createdAddresses = addressesToCheck.stream()
                .filter(address -> !StringUtils.isEmpty(address.getId()))
                .collect(Collectors.toList());
        return createdAddresses;
    }

    public List<Address> createAddresses(List<Address> addresses) {
        return addresses
                .stream()
                .map(this::saveOrUpdate)
                .collect(Collectors.toList());
    }
}
