FROM openjdk:22-jdk-slim

WORKDIR /app

COPY .env .env

COPY target/project-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]