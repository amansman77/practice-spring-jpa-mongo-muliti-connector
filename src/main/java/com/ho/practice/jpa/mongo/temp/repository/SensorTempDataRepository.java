package com.ho.practice.jpa.mongo.temp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ho.practice.jpa.mongo.temp.entity.SensorTempData;

public interface SensorTempDataRepository extends MongoRepository<SensorTempData, String> {
	
	long countByKey(String sensorId);

	void deleteByKey(String string);

}
