while [[ "$(curl -s -o /dev/null -w ''%{http_code}'' eureka:8761)" != "200" ]]; do sleep 10;done
java -jar /account/AccountService.jar  --spring.config.location=/account/

