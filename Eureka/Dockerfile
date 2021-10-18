FROM openjdk:11-jre-slim
MAINTAINER dulip
RUN mkdir /eureka
WORKDIR /eureka
COPY target/Eureka-0.0.1-SNAPSHOT.jar /eureka/Eureka.jar
COPY src/main/resources/application.properties /eureka/application.properties
CMD java -jar /eureka/Eureka.jar  --spring.config.location=/eureka/