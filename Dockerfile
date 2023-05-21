# Use an OpenJDK 8 base image
FROM openjdk:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/blog-api.jar /app

# Expose the port that the Spring Boot application listens on
EXPOSE 8080

# Set the entry point command to run the JAR file
ENTRYPOINT ["java", "-jar", "blog-api.jar"]
