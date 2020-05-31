package com.rhema.communis.common;

import com.rhema.communis.domain.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class AbstractService<T extends BaseEntity, ID> extends AbstractMongoEventListener<T> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private MongoRepository<T, ID> repository;

    public MongoRepository<T, ID> getRepository() {
        return repository;
    }

    @PostConstruct
    public void bootstrap() {
        logger.info(" Bootstrapped [" + this.getClass() + "] service with documents [" + this.repository + "]");
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
        populateAuditFromSecurityContext(t);
        logger.info("SAVE Object Request for object [" + t + "]");
        return this.repository.insert(t);
    }

    public T update(T t) {
        populateAuditFromSecurityContext(t);
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

    private void populateAuditFromSecurityContext(T t) {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        t.setLastModifiedBy(username);
        t.setLastModifiedDate(LocalDateTime.now());
        if (t.getCreatedBy() == null || t.getCreatedBy().isEmpty()) {
            t.setCreatedDate(LocalDateTime.now());
            t.setCreatedBy(username);
        }

    }

    @Autowired
    public void setRepository(MongoRepository<T, ID> repository) {
        this.repository = repository;
    }
}
