package com.peluqueria.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;


import com.peluqueria.app.entidades.Pago;

public interface PagoRepositorio extends JpaRepository <Pago, Long>{

}
