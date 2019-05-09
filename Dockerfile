FROM openjdk:11-jdk
MAINTAINER hlzhan <hlzhan@thoughtworks.com>
COPY build/libs/form-0.0.1-SNAPSHOT.jar /app/form-0.0.1-SNAPSHOT.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "form-0.0.1-SNAPSHOT.jar"]