FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/student-api-0.0.2.jar
COPY ${JAR_FILE} student-api.jar
ENTRYPOINT ["java","-jar","student-api.jar"]