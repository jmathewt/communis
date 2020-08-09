package com.rhema.communis.common;

import com.rhema.communis.domain.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public abstract class AbstractController<T extends BaseEntity, ID extends Serializable> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private AbstractService<T, ID> service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CommunisResponse> findOne(@PathVariable @NotEmpty ID id) {
        this.logger.debug("Request to Find for id : " + id);
        try {
            T result = this.service.find(id);
            return result == null ? new ResponseEntity<CommunisResponse>(new CommunisResponse(
                    new CommunisError("Unable to find result for id - " + id)),
                    HttpStatus.NOT_FOUND) :
                    new ResponseEntity<CommunisResponse>(new CommunisResponse(result),
                            HttpStatus.OK);
        } catch (ResponseStatusException r) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(r.getMessage())), r.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CommunisResponse> findAll() {
        this.logger.debug("Request to Find ALL");
        try {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(this.service.findAll()), HttpStatus.OK);
        } catch (ResponseStatusException r) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(r.getMessage())), r.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<CommunisResponse> deleteByID(@PathVariable @NotEmpty ID id) {
        this.logger.debug("Request to DELETE for id : " + id);
        try {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(this.service.deleteByID(id)), HttpStatus.OK);
        } catch (ResponseStatusException r) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(r.getMessage())), r.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<CommunisResponse> create(@Valid @RequestBody T t) {
        this.logger.debug("Request to CREATE object : " + t);
        try {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(this.service.save(t)), HttpStatus.OK);
        } catch (ResponseStatusException r) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(r.getMessage())), r.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CommunisResponse> update(@RequestBody @Valid T t) {
        this.logger.debug("Request to CREATE object : " + t);
        try {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(this.service.update(t)), HttpStatus.OK);
        } catch (ResponseStatusException r) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(r.getMessage())), r.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Autowired
    public void setService(AbstractService<T, ID> service) {
        this.service = service;
    }
}
