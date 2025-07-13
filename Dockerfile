FROM amazoncorretto:21.0.7-alpine3.20
WORKDIR /app
COPY target/blog-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]