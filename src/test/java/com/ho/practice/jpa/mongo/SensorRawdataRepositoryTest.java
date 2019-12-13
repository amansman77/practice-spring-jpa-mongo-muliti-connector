package com.ho.practice.jpa.mongo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ho.practice.jpa.mongo.backup.entity.SensorRawdata;
import com.ho.practice.jpa.mongo.backup.repository.SensorRawdataRepository;
import com.ho.practice.jpa.mongo.util.DateUtil;

@RunWith(SpringRunner.class)
//@DataMongoTest
@SpringBootTest
public class SensorRawdataRepositoryTest {

	@Autowired
	SensorRawdataRepository sensorRawdataRepository;

	@Test
	public void countBySensorIdTest() {
		//given
		String sensorId = "ST1-WT-CT-IN";
		List<SensorRawdata> testData = Arrays.asList(
				  SensorRawdata.builder().sensorId("ST1-WT-CT-IN").timekey(DateUtil.getLocalDateTime("2019-10-21 09:57:05:00", "yyyy-MM-dd HH:mm:ss:SS")).value("123").ttlDate(LocalDateTime.now()).build()
				  , SensorRawdata.builder().sensorId("ST1-WT-CT-IN").timekey(DateUtil.getLocalDateTime("2019-10-21 09:57:06:00", "yyyy-MM-dd HH:mm:ss:SS")).value("123").ttlDate(LocalDateTime.now()).build()
				  , SensorRawdata.builder().sensorId("ST1-WT-CT-IN").timekey(DateUtil.getLocalDateTime("2019-10-21 09:57:07:00", "yyyy-MM-dd HH:mm:ss:SS")).value("123").ttlDate(LocalDateTime.now()).build()
				  , SensorRawdata.builder().sensorId("ST1-WT-CT-IN").timekey(DateUtil.getLocalDateTime("2019-10-21 09:57:08:00", "yyyy-MM-dd HH:mm:ss:SS")).value("123").ttlDate(LocalDateTime.now()).build()
				  , SensorRawdata.builder().sensorId("ST2-WT-CT-IN").timekey(DateUtil.getLocalDateTime("2019-10-21 09:57:05:00", "yyyy-MM-dd HH:mm:ss:SS")).value("123").ttlDate(LocalDateTime.now()).build()
				  );
		sensorRawdataRepository.saveAll(testData);
		
		//when
		long count = sensorRawdataRepository.countBySensorId(sensorId);
		
		sensorRawdataRepository.deleteBySensorId("ST1-WT-CT-IN");
		sensorRawdataRepository.deleteBySensorId("ST2-WT-CT-IN");
		
		//then
		assertThat(count).isEqualTo(4);
	}
	
}
