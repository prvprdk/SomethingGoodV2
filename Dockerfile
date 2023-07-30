FROM gradle:7.2.0-jdk17 as someproject
COPY . .
RUN gradle build

FROM openjdk:17.0.1-jdk-slim
COPY --from=someproject /build/libs/somethinggood-0.0.1-SNAPSHOT.jar some.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "some.jar"]
