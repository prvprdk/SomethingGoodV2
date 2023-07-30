FROM gradle:7.6.1-jdk17-alpine as someproject
COPY . .
RUN gradle build &&   ls -ls build/libs

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/somethinggood-0.0.1-SNAPSHOT.jar"]
