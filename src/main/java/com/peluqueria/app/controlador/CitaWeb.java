package com.peluqueria.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.peluqueria.app.entidades.Cita;
import com.peluqueria.app.entidades.Cliente;
import com.peluqueria.app.entidades.Empleado;
import com.peluqueria.app.entidades.Pago;
import com.peluqueria.app.entidades.Servicio;
import com.peluqueria.app.repositorio.CitaRepositorio;
import com.peluqueria.app.repositorio.ClienteRepositorio;
import com.peluqueria.app.repositorio.EmpleadoRepositorio;
import com.peluqueria.app.repositorio.PagoRepositorio;
import com.peluqueria.app.repositorio.ServicioRepositorio;

@Controller

public class CitaWeb {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Autowired
	private EmpleadoRepositorio empleadoRepositorio;

	@Autowired
	private ServicioRepositorio servicioRepositorio;
	
	@Autowired
	private PagoRepositorio pagoRepositorio;

	
	@Autowired
	private  CitaRepositorio citarepositorio;
	
	@GetMapping({"/vercita"})
	public String listarEntrenador(Model model) {
		List<Cita> listaCita = citarepositorio.findAll();
		model.addAttribute("listaCita", listaCita);
		return "vercita";
	}
	
	
	
	
	@GetMapping("/formcita")
	public String mostrarFormulario (Model model) {
		model.addAttribute("cita", new Cita());
		
		
		 List<Cliente> listaCliente = clienteRepositorio.findAll();
		    List<Empleado> listaEmpleado = empleadoRepositorio.findAll();
			List<Servicio> listaServicio = servicioRepositorio.findAll();
			List<Pago> listaPago = pagoRepositorio.findAll();

		    model.addAttribute("clientes", listaCliente);
		    model.addAttribute("empleados", listaEmpleado);
		    model.addAttribute("servicios", listaServicio);
		    model.addAttribute("pagos", listaPago);
	
		List<Cita> listaCita = citarepositorio.findAll();
		model.addAttribute("listaCita", listaCita);

		return "formcita";
	}
	
	@GetMapping("/calificarcita")
	public String mostrarformularioComentario (Model model) {
		model.addAttribute("cita", new Cita());
		
		
		 List<Cliente> listaCliente = clienteRepositorio.findAll();
		    List<Empleado> listaEmpleado = empleadoRepositorio.findAll();
			List<Servicio> listaServicio = servicioRepositorio.findAll();
			List<Pago> listaPago = pagoRepositorio.findAll();

		    model.addAttribute("clientes", listaCliente);
		    model.addAttribute("empleados", listaEmpleado);
		    model.addAttribute("servicios", listaServicio);
		    model.addAttribute("pagos", listaPago);
	
		List<Cita> listaCita = citarepositorio.findAll();
		model.addAttribute("listaCita", listaCita);

		return "calificarcita";
	}
	
	@GetMapping("/pagarcita")
	public String mostrarformularioPago (Model model) {
		model.addAttribute("cita", new Cita());
		
		
		 List<Cliente> listaCliente = clienteRepositorio.findAll();
		    List<Empleado> listaEmpleado = empleadoRepositorio.findAll();
			List<Servicio> listaServicio = servicioRepositorio.findAll();
			List<Pago> listaPago = pagoRepositorio.findAll();

		    model.addAttribute("clientes", listaCliente);
		    model.addAttribute("empleados", listaEmpleado);
		    model.addAttribute("servicios", listaServicio);
		    model.addAttribute("pagos", listaPago);
	
		List<Cita> listaCita = citarepositorio.findAll();
		model.addAttribute("listaCita", listaCita);

		return "pagarcita";
	}
	
	@PostMapping("/guardarcita")
	public String guardarCita(Cita cita, RedirectAttributes redirectAttrs) {

	    // Verificar si ya existe una cita con ese empleado, fecha y hora
	    boolean existe = citarepositorio.existsByEmpleadoIdAndFechaAndHora(
	        cita.getEmpleado().getId(),
	        cita.getFecha(),
	        cita.getHora()
	    );

	    if (existe) {
	        redirectAttrs.addFlashAttribute("error", "Ya existe una cita con ese estilista en esa fecha y hora.");
	        return "redirect:/formcita"; // Asegúrate que este sea tu formulario
	    }

	    // Guardar si no hay conflicto
	    citarepositorio.save(cita);
	    redirectAttrs.addFlashAttribute("exito", "Cita registrada correctamente.");
	    return "redirect:/vercita";
	}
	
	@PostMapping("/actualizarcita")
	public String acutualizarcita (Cita cita) {
		citarepositorio.save(cita);
		return "redirect:/vercita";
	}
	
	@GetMapping("/editarcita/{id}")
	public String modificarCita (@PathVariable("id") Long id, Model model) {
		Cita cita  = citarepositorio.findById(id).get();
		model.addAttribute("cita", cita);
		
		 List<Cliente> listaCliente = clienteRepositorio.findAll();
		    List<Empleado> listaEmpleado = empleadoRepositorio.findAll();
			List<Servicio> listaServicio = servicioRepositorio.findAll();
			List<Pago> listaPago = pagoRepositorio.findAll();

		    model.addAttribute("clientes", listaCliente);
		    model.addAttribute("empleados", listaEmpleado);
		    model.addAttribute("servicios", listaServicio);
		    model.addAttribute("pagos", listaPago);
		
		
		List<Cita> listaCita = citarepositorio.findAll();
		model.addAttribute("listaCita", listaCita);

		return "formcita";
		
	}
	
	@GetMapping("/pagarcita/{id}")
	public String mostrarFormularioPago(@PathVariable Long id, Model model) {
	    Cita cita = citarepositorio.findById(id)
	            .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
	    
	    model.addAttribute("cita", cita);

	    List<Pago> listaPago = pagoRepositorio.findAll();
	    model.addAttribute("pagos", listaPago);

	    return "pagarcita"; 
	}

	@PostMapping("/pagarcita/{id}")
	public String guardarPagoCita(@PathVariable Long id,
	                              @ModelAttribute Cita cita) {
	   
	    Cita citaDb = citarepositorio.findById(id)
	            .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

	  
	    if (cita.getPago() != null && cita.getPago().getId() != null) {
	        Pago pago = pagoRepositorio.findById(cita.getPago().getId())
	                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
	        citaDb.setPago(pago);
	    } else {
	      
	        citaDb.setPago(null);
	    }

	    citarepositorio.save(citaDb);

	    return "redirect:/vercita";
	}
	
	@GetMapping("/comentarcita/{id}")
	public String mostrarFormularioComentario(@PathVariable Long id, Model model) {
	    Cita cita = citarepositorio.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
	    model.addAttribute("cita", cita);
	    return "calificarcita";
	}

	@PostMapping("/comentarcita/{id}")
	public String guardarCalificacionComentario(@PathVariable Long id,
	                                            @RequestParam String calificacion,
	                                            @RequestParam String comentario) {
	    Cita cita = citarepositorio.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
	    cita.setCalificacion(calificacion);
	    cita.setComentario(comentario);
	    citarepositorio.save(cita);
	    return "redirect:/vercita";
	}
	
	
	
	@GetMapping("/eliminarcita/{id}")
	public String eliminarcita(@PathVariable("id") Long id, Model model) {
		citarepositorio.deleteById(id);
		return "redirect:/vercita";
	}
	
	
}
