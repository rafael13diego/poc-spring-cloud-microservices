#Imágen base a utilizar
FROM openjdk:11-slim

WORKDIR /app

COPY ./target/spc-spring-gateway-0.0.1-SNAPSHOT.jar .

EXPOSE 9095

ENTRYPOINT ["java", "-jar", "spc-spring-gateway-0.0.1-SNAPSHOT.jar"]