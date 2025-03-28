FROM maven:3.9.0-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ ./src/

# Run tests and build the project
RUN mvn clean test
RUN mvn clean package

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/CalculatorProjectMain-1.0-SNAPSHOT.jar /app/calculator.jar

ENTRYPOINT ["java", "-jar", "calculator.jar"]
