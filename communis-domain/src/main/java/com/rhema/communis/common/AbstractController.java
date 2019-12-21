package com.rhema.communis.common;

import com.rhema.communis.domain.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.security.Principal;
import java.util.Date;

public abstract class AbstractController<T extends BaseEntity, ID extends Serializable> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private AbstractService<T, ID> service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommunisResponse findOne(@PathVariable @NotEmpty ID id) {
        this.logger.debug("Request to Find for id : " + id);
        try {
            return new CommunisResponse(this.service.find(id));
        } catch (ResponseStatusException r) {
            return new CommunisResponse(new CommunisError(r.getStatus(), r.getMessage()));
        } catch (Exception e) {
            return new CommunisResponse(new CommunisError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public CommunisResponse findAll() {
        this.logger.debug("Request to Find ALL");
        try {
            return new CommunisResponse(this.service.findAll());
        } catch (ResponseStatusException r) {
            return new CommunisResponse(new CommunisError(r.getStatus(), r.getMessage()));
        } catch (Exception e) {
            return new CommunisResponse(new CommunisError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommunisResponse deleteByID(@PathVariable @NotEmpty ID id) {
        this.logger.debug("Request to DELETE for id : " + id);
        try {
            return new CommunisResponse(this.service.deleteByID(id));
        } catch (ResponseStatusException r) {
            return new CommunisResponse(new CommunisError(r.getStatus(), r.getMessage()));
        } catch (Exception e) {
            return new CommunisResponse(new CommunisError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public CommunisResponse create(@RequestBody @Valid T t, Principal principal) {
        this.logger.debug("Request to CREATE object : " + t);
        try {
            t.setCreatedBy(principal.getName());
            t.setCreatedDate(new Date());
            t.setLastModifiedBy(principal.getName());
            t.setLastModifiedDate(new Date());
            return new CommunisResponse(this.service.saveOrUpdate(t));
        } catch (ResponseStatusException r) {
            return new CommunisResponse(new CommunisError(r.getStatus(), r.getMessage()));
        } catch (Exception e) {
            return new CommunisResponse(new CommunisError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public CommunisResponse update(@RequestBody @Valid T t, Principal principal) {
        this.logger.debug("Request to CREATE object : " + t);
        try {
            t.setLastModifiedBy(principal.getName());
            t.setLastModifiedDate(new Date());
            return new CommunisResponse(this.service.saveOrUpdate(t));
        } catch (ResponseStatusException r) {
            return new CommunisResponse(new CommunisError(r.getStatus(), r.getMessage()));
        } catch (Exception e) {
            return new CommunisResponse(new CommunisError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }

    @Autowired
    public void setService(AbstractService<T, ID> service) {
        this.service = service;
    }
}
