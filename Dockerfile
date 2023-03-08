FROM openjdk:17-jdk-slim
COPY --from=build /target/TinderAppMaven-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]