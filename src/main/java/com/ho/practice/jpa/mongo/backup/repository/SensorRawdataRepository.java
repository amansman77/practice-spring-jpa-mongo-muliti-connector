package com.ho.practice.jpa.mongo.backup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ho.practice.jpa.mongo.backup.entity.SensorRawdata;

public interface SensorRawdataRepository extends MongoRepository<SensorRawdata, String> {
	
	@Query(value = "{"
			+ "sensorId: {$regex : ?0}" + 
			"}", delete = true)
	void deleteBySensorId(String sensorId);

	@Query(value = "{"
			+ "sensorId: {$regex : ?0}" + 
			"}", count = true)
	long countBySensorId(String sensorId);

}
