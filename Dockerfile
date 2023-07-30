FROM gradle:7.6.1-jdk17-alpine as someproject
COPY . .
RUN gradle build && ls -ls

FROM openjdk:17.0.1-jdk-slim
COPY --from=someproject /build/libs/*.jar some.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "some.jar"]
