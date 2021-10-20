FROM java:8-jre
MAINTAINER dulip
RUN mkdir /account
WORKDIR /account
COPY startup.sh /account/startup.sh
RUN chmod +x /account/startup.sh
COPY AccountCompositeService/target/AccountCompositeService-1.0.0-SNAPSHOT.jar /account/AccountService.jar
COPY AccountCompositeService/src/main/resources/application.properties /account/application.properties
CMD java -jar /account/AccountService.jar  --spring.config.location=/account/