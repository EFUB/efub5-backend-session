# 사용할 base 이미지 선택
# ec2 아키텍쳐가 arm64v8이라서 적절한 이미지 가져옴
FROM arm64v8/eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY blog/build/libs/blog-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "app.jar"]
