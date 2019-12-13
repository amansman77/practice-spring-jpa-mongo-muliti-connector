package com.ho.practice.jpa.mongo.configuration;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import lombok.RequiredArgsConstructor;

@SuppressWarnings("deprecation")
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MongoConfig {

	private final MultipleMongoProperties mongoProperties;

    @Primary
    @Bean(name = "backupMongoTemplate")
    public MongoTemplate backupMongoTemplate() throws Exception {
        return new MongoTemplate(backupFactory(this.mongoProperties.getBackup()));
    }

    @Primary
	@Bean
    public MongoDbFactory backupFactory(final MongoProperties mongo) throws Exception {
    	if(mongo.getHost() == null) {
    		MongoClientURI uri = new MongoClientURI(mongo.getUri());
    		return new SimpleMongoDbFactory(uri);
    	}
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

    @Bean(name = "tempMongoTemplate")
    public MongoTemplate tempMongoTemplate() throws Exception {
        return new MongoTemplate(tempFactory(this.mongoProperties.getTemp()));
    }

	@Bean
    public MongoDbFactory tempFactory(final MongoProperties mongo) throws Exception {
    	if(mongo.getHost() == null) {
    		MongoClientURI uri = new MongoClientURI(mongo.getUri());
    		return new SimpleMongoDbFactory(uri);
    	}
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }
    
}
