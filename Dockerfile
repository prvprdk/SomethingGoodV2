FROM gradle:7.6.1-jdk17-alpine  
COPY . .

RUN apk add --no-cache nodejs yarn && yarn install

RUN yarn build
RUN ./gradlew build

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/somethinggood-0.0.1-SNAPSHOT.jar"]
