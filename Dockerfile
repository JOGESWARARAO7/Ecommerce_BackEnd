# Stage 1: Build the project
FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app
COPY . .

# Skip tests to avoid test failure during Docker build
RUN mvn clean install -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/JOYBackEndProject-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
