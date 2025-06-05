package com.peluqueria.app.repositorio;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peluqueria.app.entidades.Cita;


public interface CitaRepositorio extends JpaRepository <Cita, Long>{

	boolean existsByEmpleadoIdAndFechaAndHora(Long empleadoId, LocalDate fecha, LocalTime hora);
	
}
