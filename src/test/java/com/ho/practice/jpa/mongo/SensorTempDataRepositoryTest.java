package com.ho.practice.jpa.mongo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ho.practice.jpa.mongo.temp.entity.SensorTempData;
import com.ho.practice.jpa.mongo.temp.entity.SensorTempValue;
import com.ho.practice.jpa.mongo.temp.repository.SensorTempDataRepository;
import com.ho.practice.jpa.mongo.util.DateUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SensorTempDataRepositoryTest {

	@Autowired
	SensorTempDataRepository sensorTempDataRepository;

	@Test
	public void countByKeyTest() {
		//given
		String key = "TEST-SENSOR-1_123";
		String sensorId = "ST1-WT-CT-IN";
		List<SensorTempData> testData = List.of(
				SensorTempData.builder().key(key)
					.value(SensorTempValue.builder().sensorId(sensorId).data("123")
							.registDate(DateUtil.getLocalDateTime("20201214095050005", DateUtil.PATTERN_DATE_TIME_YYYYMMDDHHMMSS_SSS)).build()).build()
				);
		sensorTempDataRepository.saveAll(testData);
		
		//when
		long count = sensorTempDataRepository.countByKey(key);
		
		sensorTempDataRepository.deleteByKey(key);
		
		//then
		assertThat(count).isEqualTo(1);
	}
	
}
