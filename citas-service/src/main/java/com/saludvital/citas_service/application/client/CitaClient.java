package com.saludvital.citas_service.application.client;

import com.saludvital.citas_service.application.dto.DoctorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctores-service")
public interface CitaClient {
    @GetMapping("/api/doctores/{id}")
    DoctorDto obtenerDoctorPorId(@PathVariable Long id);
}
