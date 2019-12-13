package com.ho.practice.jpa.mongo.backup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ho.practice.jpa.mongo.backup.entity.SensorRawdata;

public interface SensorRawdataRepository extends MongoRepository<SensorRawdata, String> {
	
	void deleteBySensorId(String sensorId);

	long countBySensorId(String sensorId);

}
