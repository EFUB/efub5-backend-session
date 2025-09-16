# BEFORE (예시: arm64 고정)
# FROM arm64v8/eclipse-temurin:17-jdk-focal

# AFTER (멀티아치)
FROM eclipse-temurin:17-jre

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Duser.timezone=Asia/Seoul","/app.jar"]
