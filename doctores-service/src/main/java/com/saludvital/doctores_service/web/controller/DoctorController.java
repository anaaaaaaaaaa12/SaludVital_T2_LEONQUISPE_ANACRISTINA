package com.saludvital.doctores_service.web.controller;

import com.saludvital.doctores_service.application.service.DoctorService;
import com.saludvital.doctores_service.web.dto.DoctorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService service;

    @GetMapping
    public ResponseEntity<List<DoctorResponseDto>> findAllDoctors() {
        return ResponseEntity.ok(service.listarDoctores());
    }
}
