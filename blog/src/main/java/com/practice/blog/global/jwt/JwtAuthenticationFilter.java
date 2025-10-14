package com.practice.blog.global.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter {
    private final TokenProvider tokenProvider;

    private static final String BEARER = "Bearer ";
    private static final String HEADER = "Authorization";

    /**
     * JWT 인증 필터
     *
     * HTTP 요청을 가로채 JWT 토큰을 검사하고, 유효한 경우 인증 정보를 설정
     */


    /**
     * Authorization 헤더에서 Bearer 접두사를 제거해 토큰 추출
     */
    private String getAccessToken(String authorizationHeader){
        // Token이 null이 아니고 Bearer로 시작해야지 정상적인 Token
        if(authorizationHeader != null && authorizationHeader.startsWith(BEARER)){
            // 정상적인 토큰이라면 앞에 Bearer 제거 후 리턴
            return authorizationHeader.substring(BEARER.length());
        }
        return null;
    }
}
