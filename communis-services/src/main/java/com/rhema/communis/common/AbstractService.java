package com.rhema.communis.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.annotation.PostConstruct;
import java.util.List;

public class AbstractService<T, ID> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private MongoRepository<T, ID> repository;

    @PostConstruct
    public void bootstrap() {
        logger.info(" Bootstrapped [" + this.getClass() + "] service with repository [" + this.repository + "]");
    }

    public T find(ID id) {
        logger.info("FIND Object Request for ID [" + id + "]");
        return this.repository.findById(id).get();
    }

    public List<T> findAll() {
        logger.info("Find ALL Objects Request");
        return this.repository.findAll();
    }

    public T saveOrUpdate(T t) {
        logger.info("SAVE OR UPDATE Object Request for object [" + t + "]");
        return this.repository.save(t);
    }

    public T delete(T t) {
        this.repository.delete(t);
        logger.info("DELETE Object Request for object [" + t + "]");
        return t;
    }

    public ID deleteByID(ID id) {
        this.repository.deleteById(id);
        logger.info("DELETE Object Request for ID [" + id + "]");
        return id;
    }

    @Autowired
    public void setRepository(MongoRepository<T, ID> repository) {
        this.repository = repository;
    }
}
