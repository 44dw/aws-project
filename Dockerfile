# Start with a base image containing Java runtime
FROM openjdk:16-jdk

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/awsproject-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} awsproject.jar

# Run the jar file
ENTRYPOINT ["java","-jar","awsproject.jar"]