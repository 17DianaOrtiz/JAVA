package com.peluqueria.app.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peluqueria.app.entidades.Empleado;


public interface EmpleadoRepositorio  extends JpaRepository <Empleado, Long>{
	  Optional<Empleado> findByCorreoAndContrasena(String correo, String contrasena);

}
