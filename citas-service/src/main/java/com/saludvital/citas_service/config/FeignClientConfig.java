package com.saludvital.citas_service.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    private final JwtTokenManager jwtTokenManager;

    public FeignClientConfig(JwtTokenManager jwtTokenManager) {
        this.jwtTokenManager = jwtTokenManager;
    }

    @Bean
    public RequestInterceptor requestTokenInterceptor() {
        return requestTemplate -> {
            String token = jwtTokenManager.getJwtToken();
            if (token != null) {
                requestTemplate.header("Authorization", "Bearer " + token);
                System.out.println("DEBUG: Añadiendo token JWT a la solicitud Feign."); // Para depuración
            } else {
                System.out.println("DEBUG: No se pudo obtener token JWT para la solicitud Feign."); // Para depuración
            }
        };
    }
}