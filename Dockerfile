FROM openjdk:21-slim

EXPOSE 8080

COPY  /target/demo.jar   demo.jar

ENTRYPOINT ["java", "-jar","demo.jar"]