FROM eclipse-temurin:17

LABEL maintainer="b3abkal@gmail.com"

WORKDIR /app

COPY target/patient-management-service-0.0.1-SNAPSHOT.jar /app/patient-management-service.jar

ENTRYPOINT ["java", "-jar", "patient-management-service.jar"]