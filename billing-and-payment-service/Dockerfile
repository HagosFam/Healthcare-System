FROM openjdk:17
ADD ./out/billing-and-payment-service.jar /usr/src/billing-and-payment-service.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "billing-and-payment-service.jar"]