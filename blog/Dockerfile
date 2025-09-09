FROM openjdk:17-slim

WORKDIR /app

# 빌드한 JAR 파일을 컨테이너로 복사
COPY build/libs/*.jar app.jar

# 컨테이너 실행 명령
ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-jar", "app.jar"]
