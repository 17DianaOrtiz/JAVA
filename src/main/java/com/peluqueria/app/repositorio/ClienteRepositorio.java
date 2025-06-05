package com.peluqueria.app.repositorio;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peluqueria.app.entidades.Cliente;



public interface ClienteRepositorio extends JpaRepository <Cliente, Long>{
	
	  Optional<Cliente> findByCorreoAndContrasena(String correo, String contrasena);

}
