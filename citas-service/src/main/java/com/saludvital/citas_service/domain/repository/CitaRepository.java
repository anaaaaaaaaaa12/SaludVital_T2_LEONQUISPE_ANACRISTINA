package com.saludvital.citas_service.domain.repository;

import com.saludvital.citas_service.domain.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}
