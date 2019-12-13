package com.ho.practice.jpa.mongo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.ho.practice.jpa.mongo.backup",
        mongoTemplateRef = "backupMongoTemplate")
public class BackupMongoConfig {
}
