package com.ho.practice.jpa.mongo.configuration;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {

    private MongoProperties backup = new MongoProperties();
    private MongoProperties temp = new MongoProperties();
    
}