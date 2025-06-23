package com.saludvital.doctores_service.application.mapper;

import com.saludvital.doctores_service.domain.model.Doctor;
import com.saludvital.doctores_service.domain.model.DoctorEstado;
import com.saludvital.doctores_service.web.dto.DoctorResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public DoctorResponseDto toDto(Doctor doctor) {
        DoctorResponseDto dto = new DoctorResponseDto();
        dto.setId(doctor.getId());
        dto.setNombre(doctor.getNombre());
        dto.setEscpecialidad(doctor.getEscpecialidad());
        dto.setEstado(doctor.getEstado().name());
        return dto;
    }

    public Doctor toEntity(DoctorResponseDto dto) {
        return new Doctor(
                dto.getId(),
                dto.getNombre(),
                dto.getEscpecialidad(),
                DoctorEstado.valueOf(dto.getEstado())
        );
    }
}
