// TempConfigChecker.java

package com.practice.blog; // 본인의 프로젝트에 맞는 패키지 경로

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class TempConfigChecker {

    // application.yml 파일에서 직접 값을 읽어옵니다.
    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String clientSecret;

    // 이 클래스가 생성된 직후에 자동으로 실행되는 메소드입니다.
    @PostConstruct
    public void checkConfig() {
        System.out.println("---!!! DEBUGGING OAUTH2 CONFIG !!!---");
        System.out.println("Loaded Client ID: " + clientId);
        System.out.println("Loaded Client Secret: " + clientSecret);
        System.out.println("--------------------------------------");
    }
}
