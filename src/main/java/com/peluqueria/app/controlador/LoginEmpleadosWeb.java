package com.peluqueria.app.controlador;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.peluqueria.app.entidades.Empleado;
import com.peluqueria.app.repositorio.EmpleadoRepositorio;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller

public class LoginEmpleadosWeb {
	
	@Autowired
    private EmpleadoRepositorio empleadoRepositorio;
	
	@GetMapping("/LoginEmpleados")
    public String redirectToLoginEmpleados() {
        return "LoginEmpleados";
    }

    @PostMapping("/validarlogin")
    public String validarLogin(@RequestParam String correo,
                               @RequestParam String contrasena,
                               Model model, HttpSession session) {

        Optional<Empleado> empleadoEncontrado = empleadoRepositorio.findByCorreoAndContrasena(correo, contrasena);

        if (empleadoEncontrado.isPresent()) {
            session.setAttribute("empleado", empleadoEncontrado.get());
            return "redirect:/PaginaPrincipal"; // Página principal luego del login
        } else {
         
            return "LoginEmpleados"; // Página de login con mensaje de error
        }
    }

    @GetMapping("/logoutEmpleado")
    public String cerrarSesion(HttpSession session) {
        session.invalidate(); // Elimina todos los atributos de sesión
        return "redirect:/LoginEmpleados"; // O la página de login general
    }


}
