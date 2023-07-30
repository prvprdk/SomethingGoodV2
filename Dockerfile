//install for backend
FROM gradle:7.6.1-jdk17-alpine  
COPY . .

//install for frontend
RUN apk add --no-cache nodejs yarn && yarn install
     
//bild for frontend
 RUN yarn build

//build for backend
./gradlew build

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/somethinggood-0.0.1-SNAPSHOT.jar"]
