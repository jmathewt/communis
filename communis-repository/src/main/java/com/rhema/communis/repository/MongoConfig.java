package com.rhema.communis.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
@EnableMongoAuditing
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${datasource.name}")
    private String DATASTORE;

    @Value("${datasource.host}")
    private String HOST;

    @Value("${datasource.port}")
    private int PORT;

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://" + HOST + ":" + PORT);
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
