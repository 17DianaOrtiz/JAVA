package com.peluqueria.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.peluqueria.app.entidades.Cliente;
import com.peluqueria.app.repositorio.ClienteRepositorio;


@Controller

public class ClienteWeb {

	@Autowired
	private  ClienteRepositorio clienterepositorio;
	
	@GetMapping({"/vercliente"})
	public String listaCliente(Model model) {
		List<Cliente> listaCliente = clienterepositorio.findAll();
		model.addAttribute("listaCliente", listaCliente);
		return "vercliente";
	}
	
	@GetMapping({"/listarcliente"})
	public String listarCliente(Model model) {
		List<Cliente> listaCliente = clienterepositorio.findAll();
		model.addAttribute("listaCliente", listaCliente);
		return "listarcliente";
	}
	
	@GetMapping("/formcliente")
	public String mostrarFormulario (Model model) {
		model.addAttribute("cliente", new Cliente());
	
	    
		List<Cliente> listaCliente = clienterepositorio.findAll();
		model.addAttribute("listaCliente", listaCliente);

		return "formcliente";
	}
	
	
	@GetMapping("/registrarcliente")
	public String mostrarRegistro (Model model) {
		model.addAttribute("cliente", new Cliente());
	
	    
		List<Cliente> listaCliente = clienterepositorio.findAll();
		model.addAttribute("listaCliente", listaCliente);

		return "registrarcliente";
	}
	
	@PostMapping("/guardarcliente")
	public String guardarCliente (Cliente cliente) {
		clienterepositorio.save(cliente);
		return "redirect:/listarcliente";
	}
	
	@PostMapping("/clienteguardausuario")
	public String guardarCliente2 (Cliente cliente) {
		clienterepositorio.save(cliente);
		return "redirect:/LoginClientes";
	}
	
	@GetMapping("/editarcliente/{id}")
	public String modificarCliente(@PathVariable("id") Long id, Model model) {
		Cliente  cliente = clienterepositorio.findById(id).get();
		model.addAttribute("cliente",cliente);
		List<Cliente> listaCliente = clienterepositorio.findAll();
		model.addAttribute("listaCliente", listaCliente);

		return "formcliente";
		
	}
	
	@GetMapping("/eliminarcliente/{id}")
	public String eliminarcliente(@PathVariable("id") Long id, Model model) {
		clienterepositorio.deleteById(id);
		return "redirect:/listarcliente";
	}
	
}
