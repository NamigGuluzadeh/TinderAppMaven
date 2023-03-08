FROM maven:3.8.2-jdk-17 AS build
COPY . .


FROM openjdk:17-jdk-slim
COPY --from=build /target/TinderAppMaven-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]