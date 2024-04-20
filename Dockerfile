FROM openjdk:17-jdk-slim

COPY . /app
WORKDIR /app

RUN ./gradlew bootJar

FROM openjdk:17-jdk-slim
COPY --from=0 /app/build/libs/cloud-app-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

#docker build -t cloud-app:latest .
#docker run -it --name prasada cloud-app:latest
#docker run -it --name prasada -p 8080:8080 cloud-app:latest
#docker stop prasada
#docker rm prasda