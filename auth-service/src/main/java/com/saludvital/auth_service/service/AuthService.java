package com.saludvital.auth.service;

import com.saludvital.auth.entity.Client;
import com.saludvital.auth.repository.ClientRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {
    private final ClientRepository clientRepository;
    @Value("${security.jwt.secret}")
    private String SECRET;
    @Value("${security.jwt.expiration}")
    private long EXPIRATION_TIME;

    public AuthService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String generateToken(String clientId, String clientSecret) {
        Optional<Client> clientOpt = clientRepository.findByClientIdAndClientSecretAndEnabled(clientId, clientSecret, true);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            Map<String, Object> claims = new HashMap<>();
            claims.put("sub", client.getClientId());
            claims.put("clienteId", client.getClientId());
            claims.put("description", client.getDescription());
            return createToken(claims, client.getClientId());
        }
        return null;
    }

    private String createToken(Map<String, Object> claims, String userName) {
        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
