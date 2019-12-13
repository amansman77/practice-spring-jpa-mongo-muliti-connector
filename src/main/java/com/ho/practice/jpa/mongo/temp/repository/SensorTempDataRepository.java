package com.ho.practice.jpa.mongo.temp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ho.practice.jpa.mongo.temp.entity.SensorTempData;

public interface SensorTempDataRepository extends MongoRepository<SensorTempData, String> {
	
	@Query(value = "{"
			+ "\"value.sensorId\": {$regex : ?0}" + 
			"}", count = true)
	long countBySensorId(String sensorId);

	@Query(value = "{"
			+ "\"value.sensorId\": {$regex : ?0}" + 
			"}", sort = "{\"value.registDate\":-1}")
	List<SensorTempData> findBySensorId(String sensorId, Pageable pageable);
	
	@Query(value = "{"
			+ "\"value.sensorId\": {$regex : ?0}" + 
			"}", delete = true)
	void deleteBySensorId(String testMongoSensorId);
	
	void deleteByKey(String string);

	long countByKey(String key);

}
