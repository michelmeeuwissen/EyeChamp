package com.eyechamp.cfg;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Michel on 21-2-2015.
 */
@Configuration
@EnableMongoRepositories("com.eyechamp")
@PropertySource(value="classpath:db.properties")
public class DbConfig extends AbstractMongoConfiguration {

    @Autowired
    Environment env;

    @Bean
    public MongoFactoryBean mongoFactoryBean(){
        MongoFactoryBean mongo = new MongoFactoryBean();
        String mongodbUrl = env.getProperty("mongodb.url");
        String mongodPort = env.getProperty("mongodb.port");
        mongo.setHost(mongodbUrl);
        mongo.setPort(Integer.parseInt(mongodPort));
        return mongo;
    }

    @Override
    protected String getDatabaseName() {
        return "eyechamp";
    }

    @Override
    public Mongo mongo() throws Exception {
        MongoFactoryBean mongoFactoryBean = mongoFactoryBean();
        return mongoFactoryBean.getObject();
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.eyechamp.repositories";
    }
}
