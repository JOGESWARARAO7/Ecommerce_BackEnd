
FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean install

# ----------------------
# Create the final image
# ----------------------

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/JOYBackEndProject-0.0.1-SNAPSHOT.jar app.jar

# Expose application port (default for Spring Boot)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
