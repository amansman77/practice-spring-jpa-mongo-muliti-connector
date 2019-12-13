package com.ho.practice.jpa.mongo.backup.entity;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ho.practice.jpa.mongo.util.DateUtil;
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
public class SensorRawdata {

	@Field("sensor_id")
	@NonNull
	private String sensorId;
	
	@NonNull
	private LocalDateTime timekey;
	
	@NonNull
	private String value;
	
	private LocalDateTime ttlDate;
	
	public String toCsvString() {
		return sensorId
				+ "," + Optional.ofNullable(DateUtil.toString(timekey, "yyyy-MM-dd HH:mm:ss:SS")).orElse("")
				+ "," + Optional.ofNullable(value).orElse("");
	}
}
