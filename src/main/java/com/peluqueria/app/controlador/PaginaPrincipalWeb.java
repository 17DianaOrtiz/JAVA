package com.peluqueria.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PaginaPrincipalWeb {

	@GetMapping({"/PaginaPrincipal"})
	public String redirectToHomePage() {
		return "PaginaPrincipal";
}
	
	
}
