package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the RECLAMO database table.
 * 
 */
@Entity
@NamedQuery(name="Reclamo.findAll", query="SELECT r FROM Reclamo r")
public class Reclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECLAMO_IDRECLAMO_GENERATOR", sequenceName="SEQ_ID_RECLAMO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECLAMO_IDRECLAMO_GENERATOR")
	@Column(name="ID_RECLAMO")
	private long idReclamo;

	//	FECHA GUARDADA POR EL SISTEMA
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;
	
	//	FECHA GUARDADA POR EL USUARIO
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA")
	private Date fechaHora;
	
	@Column(name="HABILITADO")
	private int habilitado;

	
	@Column(name="CREDITO")
	private Integer credito;
	
	@Column(name="SEMESTRE")
	private String semestre;
	
	@Column(name="TITULO")
	private String titulo;
	

	@Column(name="DETALLE")
	private String detalle;
	
	@Column(name="NOMBRE_ACTIVIDAD")
	private String nombreActividad;
	
	
	//uni-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="ID_ESTUDIANTE")
	private Estudiante estudiante;

	//uni-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO")
	private Evento evento;

	//bi-directional many-to-one association to Tutor
	@ManyToOne
	@JoinColumn(name="ID_TUTOR")
	private Tutor tutor;
	
	//bi-directional many-to-one association to Tutor
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Reclamo() {
	}

	public long getIdReclamo() {
		return this.idReclamo;
	}

	public void setIdReclamo(long idReclamo) {
		this.idReclamo = idReclamo;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Tutor getTutor() {
		return this.tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getCredito() {
		return credito;
	}

	public void setCredito(Integer credito) {
		this.credito = credito;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public boolean getHabilitado() {
		return habilitado > 0;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado ? 1 : 0;
	}
	
	

}