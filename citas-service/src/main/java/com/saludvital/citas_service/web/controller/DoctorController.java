package com.saludvital.citas_service.web.controller;

import com.saludvital.citas_service.application.service.CitaService;
import com.saludvital.citas_service.web.dto.CitaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class DoctorController {

    private final CitaService service;

    @GetMapping
    public ResponseEntity<List<CitaResponseDto>> listar() {
        return ResponseEntity.ok(service.listarCitas());
    }
}
