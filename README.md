# Springboot기반 JPA로 두개의 몽고DB에 접속하기


## 목표
Springboot기반 JPA로 두개의 몽고DB를 접속하자


## 개발 프레임워크
 - IDE : STS-4.2.2.RELEASE
 - Java : openjdk 12.0.1
 - Spring Boot : 2.2.1
 - Gradle : 5.6.4
 - Data-MongoDB : 2.2.1


## 구현
[Multiple MongoDB connectors with Spring Boot - Marcos Barbero's Blog](https://blog.marcosbarbero.com/multiple-mongodb-connectors-in-spring-boot/)를 참고해서 구현했습니다.

1. Springboot의 AutoConfig를 disable합니다.
```java
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
```

2. Property를 작성하고 Configuration을 생성합니다.

`application.properties`, `MultipleMongoProperties`에 구현

이 때 property의 두번째 인자와 Configuration의 변수명을 동일하게 맞춥니다.

3. MongoTemplate을 작성합니다.

`MongoConfig`에 구현

4. Repository와 MongoTemplate을 맵핑합니다.

`BackupMongoConfig`와 `TempMongoConfig` 구현

5. 테스트는 @SpringBootTest로 수행합니다. 