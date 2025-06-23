package com.saludvital.doctores_service.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorResponseDto {
    private Long id;
    private String nombre;
    private String escpecialidad;
    private String estado;
}
