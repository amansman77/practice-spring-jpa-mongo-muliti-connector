package com.ho.practice.jpa.mongo.temp.entity;

import com.mongodb.lang.NonNull;

import lombok.Builder;
import lombok.Data;

/**
 * @author hhsung
 *
 */
@Data
@Builder
public class SensorTempValue {

	@NonNull
	private String sensorId;
	
	@NonNull
	private String data;
	
	@NonNull
	private String registDate;
	
}
