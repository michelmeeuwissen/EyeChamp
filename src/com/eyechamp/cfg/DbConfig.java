package com.eyechamp.cfg;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Michel on 21-2-2015.
 */
@Configuration
@EnableMongoRepositories("com.eyechamp")
public class DbConfig extends AbstractMongoConfiguration {

    @Bean
    public MongoFactoryBean mongoFactoryBean(){
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }

    @Override
    protected String getDatabaseName() {
        return "eyechamp";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.eyechamp.repositories";
    }
}
