# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS BUILDER

# Set the working directory
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17

# Set the working directory for the runtime
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=BUILDER /app/target/*.jar app.jar

# Command to run the application
CMD ["java", "-jar", "app.jar"]