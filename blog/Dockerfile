FROM openjdk:17-slim

ARG FAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java"< "-jar", "-Duser.timezone=Asia/Seoul", "/app.jar"]
