package com.saludvital.citas_service.application.service;

import com.saludvital.citas_service.web.dto.CitaResponseDto;

import java.util.List;

public interface CitaService {
    List<CitaResponseDto> listarCitas();
}
