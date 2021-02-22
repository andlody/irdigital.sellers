FROM maven:3.5-jdk-8-alpine as builder

WORKDIR /app
COPY pom.xml .
COPY src ./src
EXPOSE 8080

RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk8:jdk8u202-b08-alpine-slim

COPY --from=builder /app/target/*.jar /sellers.jar

CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=8080","-jar","/sellers.jar"]