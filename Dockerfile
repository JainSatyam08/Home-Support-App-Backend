# ==========================
# Stage 1 : Build
# ==========================
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Maven Wrapper
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .

RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build application
RUN ./mvnw clean package -DskipTests


# ==========================
# Stage 2 : Runtime
# ==========================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy generated JAR
COPY --from=builder /app/target/*.jar app.jar

# Render provides PORT automatically
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
