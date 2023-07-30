FROM openjdk:17-jdk-alpine
COPY . /app/backend
RUN apk add --no-cache nodejs yarn && \
    cd /app/frontend && \
    yarn install

RUN cd /app/frontend && \
    yarn build && \
    mkdir -p /app/backend/src/main/resources/static && \
    cp -r /app/frontend/build/* /app/backend/src/main/resources/static/

RUN cd /app/backend && \
    ./gradlew build

CMD ["java", "-jar", "/app/backend/gradle/libs/somethinggood-0.0.1-SNAPSHOT.jar"]
