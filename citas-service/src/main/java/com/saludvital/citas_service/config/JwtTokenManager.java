package com.saludvital.citas_service.config;

import com.saludvital.citas_service.client.AuthServiceClient;
import com.saludvital.citas_service.dto.AuthRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date; // Asegúrate de importar Date

@Component
public class JwtTokenManager {
    private final AuthServiceClient authServiceClient;
    private String currentJwtToken; // Almacena el token actual

    @Value("${citas.service.client-id}")
    private String clientId;

    @Value("${citas.service.client-secret}")
    private String clientSecret;

    public JwtTokenManager(AuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    public String getJwtToken() {
        // Simple comprobación, en real se valida la expiración del JWT
        if (currentJwtToken == null || isTokenAboutToExpire(currentJwtToken)) {
            AuthRequest authRequest = new AuthRequest(clientId, clientSecret);
            try {
                currentJwtToken = authServiceClient.getToken(authRequest);
                System.out.println("DEBUG: Token obtenido: " + currentJwtToken); 
            } catch (Exception e) {
                System.err.println("ERROR: No se pudo obtener el token de auth-service: " + e.getMessage());
                currentJwtToken = null;
            }
        }
        return currentJwtToken;
    }

    
    private boolean isTokenAboutToExpire(String token) {
       
        return token == null; 
    }
}
