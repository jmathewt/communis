package com.rhema.communis.common;

import com.rhema.communis.domain.BaseEntity;
import com.rhema.communis.domain.CommunisResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.security.Principal;
import java.util.Date;

public abstract class AbstractController<T extends BaseEntity, ID extends Serializable> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private AbstractService<T, ID> service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommunisResponse findOne(@PathVariable ID id) {
        this.logger.debug("Request to Find for id : " + id);
        try {
            return new CommunisResponse(this.service.find(id));
        } catch (Exception e) {
            this.logger.error("Exception retrieving Object ", e);
            return new CommunisResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public CommunisResponse findAll() {
        this.logger.debug("Request to Find ALL");
        try {
            return new CommunisResponse(this.service.findAll());
        } catch (Exception e) {
            this.logger.error("Exception retrieving ALL Objects ", e);
            return new CommunisResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommunisResponse deleteByID(@PathVariable ID id) {
        this.logger.debug("Request to DELETE for id : " + id);
        try {
            return new CommunisResponse(this.service.deleteByID(id));
        } catch (Exception e) {
            this.logger.error("Exception deleting Object ", e);
            return new CommunisResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public CommunisResponse create(@RequestBody T t, Principal principal) {
        this.logger.debug("Request to CREATE object : " + t);
        try {
            t.setCreatedBy(principal.getName());
            t.setCreatedDate(new Date());
            t.setLastModifiedBy(principal.getName());
            t.setLastModifiedDate(new Date());
            return new CommunisResponse(this.service.saveOrUpdate(t));
        } catch (Exception e) {
            this.logger.error("Exception creating Object ", e);
            return new CommunisResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public CommunisResponse update(@RequestBody T t, Principal principal) {
        this.logger.debug("Request to CREATE object : " + t);
        try {
            t.setLastModifiedBy(principal.getName());
            t.setLastModifiedDate(new Date());
            return new CommunisResponse(this.service.saveOrUpdate(t));
        } catch (Exception e) {
            this.logger.error("Exception updating Object ", e);
            return new CommunisResponse(e.getMessage());
        }
    }

    @Autowired
    public void setService(AbstractService<T, ID> service) {
        this.service = service;
    }
}
