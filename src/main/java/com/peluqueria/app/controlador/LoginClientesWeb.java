package com.peluqueria.app.controlador;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peluqueria.app.entidades.Cliente;
import com.peluqueria.app.repositorio.ClienteRepositorio;


import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller

public class LoginClientesWeb {
	
	@Autowired
    private ClienteRepositorio clienteRepositorio;
	
	
	@GetMapping("/LoginClientes")
    public String redirectLoginClientes() {
        return "LoginClientes"; // Sin extensión .html
    }
	

    @PostMapping("/validarlogin1")
    public String validarLogin1(@RequestParam String correo,
                               @RequestParam String contrasena,
                               Model model, HttpSession session) {

        Optional<Cliente> clienteEncontrado = clienteRepositorio.findByCorreoAndContrasena(correo, contrasena);

        if (clienteEncontrado.isPresent()) {
            session.setAttribute("cliente", clienteEncontrado.get());
            return "redirect:/PaginaPrincipal"; // Página principal luego del login
        } else {
            
            return "LoginClientes"; // Página de login con mensaje de error
        }
    }
    
    
    @GetMapping("/logoutCliente")
    public String cerrarSesion(HttpSession session) {
        session.invalidate(); // Elimina todos los atributos de sesión
        return "redirect:/LoginClientes"; // O la página de login general
    }

   

}
