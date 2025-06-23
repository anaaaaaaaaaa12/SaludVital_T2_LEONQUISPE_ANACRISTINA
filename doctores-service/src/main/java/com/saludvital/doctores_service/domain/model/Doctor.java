package com.saludvital.doctores_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Doctor {
    private Long id;
    private String nombre;
    private String escpecialidad;
    private DoctorEstado estado;
}
