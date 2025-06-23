package com.saludvital.citas_service.application.service.impl;

import com.saludvital.citas_service.application.mapper.CitaMapper;
import com.saludvital.citas_service.application.service.CitaService;
import com.saludvital.citas_service.domain.repository.CitaRepository;
import com.saludvital.citas_service.web.dto.CitaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepository repository;
    private final CitaMapper mapper;

    @Override
    public List<CitaResponseDto> listarCitas() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }
}
