package com.ho.practice.jpa.mongo.temp.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Builder;
import lombok.Data;

/**
 * @author hhsung
 *
 */
@Data
@Builder
@Document(collection = "sensor_data")
public class SensorTempData {

	@NonNull
	private String key;
	
	@NonNull
	private SensorTempValue value;
	
}
