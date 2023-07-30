FROM gradle:7.6.1-jdk17-alpine AS backend-builder
COPY . .
RUN gurdle build

FROM openjdk:17.0.1-jdk-slim

COPY --from=backend-builder /build/libs/somethinggood-0.0.1-SNAPSHOT.jar some.jar
ENTRYPOINT ["java", "-jar", "some.jar"]