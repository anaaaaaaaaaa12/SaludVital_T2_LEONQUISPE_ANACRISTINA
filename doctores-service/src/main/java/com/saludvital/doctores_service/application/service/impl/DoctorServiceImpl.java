package com.saludvital.doctores_service.application.service.impl;

import com.saludvital.doctores_service.application.mapper.DoctorMapper;
import com.saludvital.doctores_service.application.service.DoctorService;
import com.saludvital.doctores_service.domain.model.Doctor;
import com.saludvital.doctores_service.domain.model.DoctorEstado;
import com.saludvital.doctores_service.web.dto.DoctorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorMapper mapper;

    @Override
    public List<DoctorResponseDto> listarDoctores() {
        return doctorList().stream().map(mapper::toDto).toList();
    }

    private List<Doctor> doctorList() {
        return List.of(
                new Doctor(1L, "Ana Leon", "Psicología", DoctorEstado.ACTIVO),
                new Doctor(2L, "Carlos Pérez", "Cardiología", DoctorEstado.INACTIVO),
                new Doctor(3L, "Lucía Gómez", "Dermatología", DoctorEstado.ACTIVO)
        );
    }
}
