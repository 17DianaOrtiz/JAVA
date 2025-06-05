package com.peluqueria.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.peluqueria.app.entidades.Servicio;
import com.peluqueria.app.repositorio.ServicioRepositorio;

@Controller

public class ServicioWeb {

	
	@Autowired
	private  ServicioRepositorio serviciorepositorio;
	
	@GetMapping({"/verservicio"})
	public String listarServicio(Model model) {
		List<Servicio> listaServicio = serviciorepositorio.findAll();
		model.addAttribute("listaServicio", listaServicio);
		return "verservicio";
	}
	
	@GetMapping("/formservicio")
	public String mostrarFormulario (Model model) {
		model.addAttribute("servicio", new Servicio());
	
	    
		List<Servicio> listaServicio = serviciorepositorio.findAll();
		model.addAttribute("listaServicio", listaServicio);

		return "formservicio";
	}
	
	@PostMapping("/guardarservicio")
	public String guardarServicio (Servicio servicio) {
		serviciorepositorio.save(servicio);
		return "redirect:/verservicio";
	}
	
	@GetMapping("/editarservicio/{id}")
	public String modificarServicio(@PathVariable("id") Long id, Model model) {
		Servicio servicio = serviciorepositorio.findById(id).get();
		model.addAttribute("servicio",servicio);
		List<Servicio> listaServicio = serviciorepositorio.findAll();
		model.addAttribute("listaServicio", listaServicio);

		return "formservicio";
		
	}
	
	@GetMapping("/eliminarservicio/{id}")
	public String eliminarservicio(@PathVariable("id") Long id, Model model) {
		serviciorepositorio.deleteById(id);
		return "redirect:/verservicio";
	}
	
}
