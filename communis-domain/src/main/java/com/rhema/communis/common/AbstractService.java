package com.rhema.communis.common;

import com.rhema.communis.domain.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class AbstractService<T extends BaseEntity, ID> extends AbstractMongoEventListener<T> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MongoOperations mongoOperations;

    private MongoRepository<T, ID> repository;

    public MongoRepository<T, ID> getRepository() {
        return repository;
    }

    public MongoOperations getMongoOperations() {
        return mongoOperations;
    }

    @PostConstruct
    public void bootstrap() {
        logger.info(" Bootstrapped [" + this.getClass() + "] service with repository [" + this.repository + "]");
    }

    public T find(ID id) {
        logger.info("FIND Object Request for ID [" + id + "]");
        return this.repository.findById(id).orElse(null);
    }

    public List<T> findAll() {
        logger.info("Find ALL Objects Request");
        return this.repository.findAll();
    }

    public T save(T t) {
        logger.info("SAVE Object Request for object [" + t + "]");
        return this.repository.insert(t);
    }

    public T update(T t) {
        AtomicReference<T> out = new AtomicReference<>();
        if (t.getId() != null) {
            logger.info("UPDATE Object Request for object [" + t + "]");
            this.repository.findById((ID) t.getId()).ifPresent(tDb -> {
                BeanUtils.copyProperties(t, tDb, "version", "createdBy", "createdDate");
                out.set(repository.save(tDb));
            });
        } else {
            logger.info("SAVE Object Request for object [" + t + "]");
            out.set(repository.save(t));
        }
        return out.get();
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
