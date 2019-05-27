package com.rhema.communis.repository;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${datasource.name}")
    private String DATASTORE;

    @Value("${datasource.host}")
    private String HOST;

    @Value("${datasource.port}")
    private int PORT;

    @Override
    public MongoClient mongoClient() {
        MongoClient mongoClient = new MongoClient(HOST,PORT);
        return mongoClient;
    }

    /* GridFs Configuration */
    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName() {
        return DATASTORE != null ? DATASTORE : "test";
    }
}
