# Use OpenJDK as the base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/CalculatorProjectMain-1.0-SNAPSHOT.jar /app/calculator.jar

# Set the entry point to run the JAR
ENTRYPOINT ["java", "-jar", "calculator.jar"]
