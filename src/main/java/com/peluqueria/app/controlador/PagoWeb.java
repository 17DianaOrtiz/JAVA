package com.peluqueria.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.peluqueria.app.entidades.Pago;
import com.peluqueria.app.repositorio.PagoRepositorio;




@Controller
public class PagoWeb {

	@Autowired
	private  PagoRepositorio pagorepositorio;
	
	@GetMapping({"/verpago"})
	public String listarPago(Model model) {
		List<Pago> listaPago = pagorepositorio.findAll();
		model.addAttribute("listaPago", listaPago);
		return "verpago";
	}
	
	@GetMapping("/formpago")
	public String mostrarFormulario (Model model) {
		model.addAttribute("pago", new Pago());
	
	    
		List<Pago> listaPago = pagorepositorio.findAll();
		model.addAttribute("listaPago", listaPago);

		return "formpago";
	}
	
	@PostMapping("/guardarpago")
	public String guardarPago (Pago pago) {
		pagorepositorio.save(pago);
		return "redirect:/verpago";
	}
	
	@GetMapping("/editarpago/{id}")
	public String modificarPago(@PathVariable("id") Long id, Model model) {
		Pago pago = pagorepositorio.findById(id).get();
		model.addAttribute("pago",pago);
		List<Pago> listaPago = pagorepositorio.findAll();
		model.addAttribute("listaPago", listaPago);

		return "formpago";
		
	}
	
	@GetMapping("/eliminarpago/{id}")
	public String eliminarpago(@PathVariable("id") Long id, Model model) {
		pagorepositorio.deleteById(id);
		return "redirect:/verpago";
	}
	
	
}
