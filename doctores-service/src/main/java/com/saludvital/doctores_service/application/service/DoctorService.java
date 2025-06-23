package com.saludvital.doctores_service.application.service;

import com.saludvital.doctores_service.domain.model.Doctor;
import com.saludvital.doctores_service.web.dto.DoctorResponseDto;

import java.util.List;

public interface DoctorService {
    List<DoctorResponseDto> listarDoctores();
}
