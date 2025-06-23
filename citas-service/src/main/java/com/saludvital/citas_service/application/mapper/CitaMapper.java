package com.saludvital.citas_service.application.mapper;

import com.saludvital.citas_service.domain.model.Cita;
import com.saludvital.citas_service.domain.model.CitaEstado;
import com.saludvital.citas_service.web.dto.CitaResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CitaMapper {
    public CitaResponseDto toDto(Cita cita) {
        CitaResponseDto dto = new CitaResponseDto();
        dto.setId(cita.getId());
        dto.setFecha(cita.getFecha());
        dto.setPaciente(cita.getPaciente());
        dto.setDoctorId(cita.getDoctorId());
        dto.setEstado(cita.getEstado().name());
        dto.setNotas(cita.getNotas());
        dto.setHora(cita.getHora());
        return dto;
    }

    public Cita toEntity(CitaResponseDto dto) {
        Cita cita = new Cita();
        cita.setId(dto.getId());
        cita.setFecha(dto.getFecha());
        cita.setPaciente(dto.getPaciente());
        cita.setDoctorId(dto.getDoctorId());
        cita.setEstado(CitaEstado.valueOf(dto.getEstado()));
        cita.setNotas(dto.getNotas());
        cita.setHora(dto.getHora());
        return cita;
    }
}
