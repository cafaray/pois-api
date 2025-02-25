# Build Stage
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

# Runtime Stage
FROM docker.io/khipu/openjdk17-alpine:latest
WORKDIR /app
# RUN apk add --no-cache curl
COPY --from=builder /build/target/pois-api-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]