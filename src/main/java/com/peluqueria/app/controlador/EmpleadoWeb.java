package com.peluqueria.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.peluqueria.app.entidades.Empleado;
import com.peluqueria.app.repositorio.EmpleadoRepositorio;


@Controller

public class EmpleadoWeb {


	@Autowired
	private  EmpleadoRepositorio empleadorepositorio;
	
	@GetMapping({"/verempleado"})
	public String listaEmpleado(Model model) {
		List<Empleado> listaEmpleado = empleadorepositorio.findAll();
		model.addAttribute("listaEmpleado", listaEmpleado);
		return "verempleado";
	}
	
	@GetMapping({"/listarempleado"})
	public String listarEmpleado(Model model) {
		List<Empleado> listaEmpleado = empleadorepositorio.findAll();
		model.addAttribute("listaEmpleado", listaEmpleado);
		return "listarempleado";
	}
	
	@GetMapping("/formempleado")
	public String mostrarFormulario (Model model) {
		model.addAttribute("empleado", new Empleado());
	
	    
		List<Empleado> listaEmpleado = empleadorepositorio.findAll();
		model.addAttribute("listaEmpleado", listaEmpleado);

		return "formempleado";
	}
	
	@PostMapping("/guardarempleado")
	public String guardarEmpleado (Empleado empleado) {
		empleadorepositorio.save(empleado);
		return "redirect:/listarempleado";
	}
	
	@GetMapping("/editarempleado/{id}")
	public String modificarEmpleado(@PathVariable("id") Long id, Model model) {
		Empleado empleado = empleadorepositorio.findById(id).get();
		model.addAttribute("empleado",empleado);
		List<Empleado> listaEmpleado = empleadorepositorio.findAll();
		model.addAttribute("listaEmpleado", listaEmpleado);

		return "formempleado";
		
	}
	
	@GetMapping("/eliminarempleado/{id}")
	public String eliminarempleado(@PathVariable("id") Long id, Model model) {
		empleadorepositorio.deleteById(id);
		return "redirect:/listarempleado";
	}
	
}
