package com.saludvital.citas_service.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class CitaResponseDto {
    private Long id;
    private LocalDate fecha;
    private String paciente;
    private Long doctorId;
    private String estado;
    private String notas;
    private LocalTime hora;
}
