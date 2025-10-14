package com.practice.blog.global.config;

import com.practice.blog.account.service.CustomOAuth2UserService;
import com.practice.blog.global.handler.OAuth2AuthenticationSuccessHandler;
import com.practice.blog.global.jwt.JwtAuthenticationFilter;
import com.practice.blog.global.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    /**
     * SecurityFilterChain 설정을 위한 Bean 등록
     * HTTP 요청에 대한 보안 구성을 정의하고, JWT 인증 필터 추가
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 기본 인증 방식 비활성화 (UI 대신 토큰을 통한 인증을 사용하기 때문)

                // CSRF 보호 비활성화 (토큰 기반 인증이므로 필요하지 않음)

                //cors 설정 추가

                // 요청에 따른 인증 인가 설정

                    /* 액세스토큰 재발급, GET요청은 모두 허용 */

                    /* 다른 모든 요청은 인증을 요구 */


                // JWT를 사용하므로 sateless

                // JWT 인증 필터를 UsernamePAsswordAuthenticationFilter 앞에 추가하여 JWT를 통한 인증 수행

                // OAuth2 로그인 설정 - 인증된 사용자 정보(프로필)를 가져오는 방식 정의, 인증 성공시 동작을 정의하는 successHandler 설정



    // ============== [ CORS 설정 Bean 추가 ] ==============

        // 1. 허용할 출처(프론트엔드)를 명시


        // 2. 허용할 HTTP 메서드(GET, POST 등)를 명시


        // 3. 허용할 HTTP 헤더를 명시


        // 4. 자격 증명(쿠키, 인증 헤더 등)을 허용할지 여부를 설정
        // true로 설정해야 Authorization 헤더에 담긴 JWT 토큰을 주고받기 가능


        // 모든 경로(/)에 대해 위에서 정의한 CORS 설정을 적용

    // ===============================================
}
