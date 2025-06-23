package com.saludvital.citas_service.client;

import com.saludvital.citas_service.dto.AuthRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "${auth.service.url}")
public interface AuthServiceClient {
    @PostMapping("/auth/token")
    String getToken(@RequestBody AuthRequest authRequest);
}
