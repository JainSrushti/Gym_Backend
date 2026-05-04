# STAGE 1: Build the application
# We use a Maven image with JDK 17 to compile the code
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
# Copy your pom.xml and source code
COPY pom.xml .
COPY src ./src
# Build the JAR file, skipping tests to speed up deployment
RUN mvn clean package -DskipTests

# STAGE 2: Run the application
# We use a slim JDK 17 image to keep the final size small
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy the JAR from the build stage (match the name from your pom.xml)
COPY --from=build /app/target/gymbackend-0.0.1-SNAPSHOT.jar gym-app.jar
# Expose the port Spring Boot runs on
EXPOSE 8080
# The command to start your app
ENTRYPOINT ["java", "-jar", "gym-app.jar"]