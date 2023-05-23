FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} billing-and-payment-service.jar
ENTRYPOINT ["java","-jar", "/billing-and-payment-service.jar"]
EXPOSE 8081