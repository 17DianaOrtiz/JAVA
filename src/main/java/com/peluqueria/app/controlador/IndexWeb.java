package com.peluqueria.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexWeb {

	@GetMapping({"/","/index","/inicio"})
	public String redirectToHomePage() {
		return "index";
}
	
}
