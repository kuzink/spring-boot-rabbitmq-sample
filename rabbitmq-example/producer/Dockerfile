FROM openjdk:8-jdk-alpine
ADD target/spring-boot-rabbitmq-producer.jar spring-boot-rabbitmq-producer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "spring-boot-rabbitmq-producer.jar"]