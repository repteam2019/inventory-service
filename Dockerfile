FROM openjdk:8-jdk-alpine
EXPOSE 2022
ADD /target/inventory-service-1.0.0.jar inventory-service-1.0.0.jar
ENTRYPOINT ["java", "-jar", "inventory-service-1.0.0.jar"]
