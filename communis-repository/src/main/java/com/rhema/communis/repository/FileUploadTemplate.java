package com.rhema.communis.repository;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.Map;

@Repository
public class FileUploadTemplate {
    private final String STORE = "store";
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GridFsTemplate gridFsTemplate;

    public String upload(@NonNull InputStream file, String fileName, String contentType, @NonNull String store, Map<String, Object> metadata) {
        metadata.put(STORE, store);
        return gridFsTemplate.store(file, fileName, contentType, metadata).toString();
    }

    public GridFsResource findOne(@NonNull String id) {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        return new GridFsResource(file);
    }

    public void delete(@NonNull String id) {
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
    }
}
