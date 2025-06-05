package com.peluqueria.app.entidades;

import java.time.LocalDate;
import java.time.LocalTime;




import jakarta.persistence.*;

@Entity
@Table(name="citas")

public class Cita {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate fecha;          
	private LocalTime hora;          
	private String asistencia;        
	private String estadoServicio;    
	private String calificacion;      
	private String comentario; 
	
	
	   @ManyToOne
	    @JoinColumn(name = "cliente_id")  
	    private Cliente cliente;
	
	   @ManyToOne
	    @JoinColumn(name = "pago_id")  
	    private Pago pago;
	   
	   @ManyToOne
	    @JoinColumn(name = "empleado_id")  
	    private Empleado empleado;
	   
	   @ManyToOne
	    @JoinColumn(name = "servicio_id")  
	    private Servicio servicio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}

	public String getEstadoServicio() {
		return estadoServicio;
	}

	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	   
	  
	

	

}
