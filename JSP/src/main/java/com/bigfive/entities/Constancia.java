package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CONSTANCIA database table.
 * 
 */
@Entity
@NamedQuery(name="Constancia.findAll", query="SELECT c FROM Constancia c")
public class Constancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONSTANCIA_IDCONSTANCIA_GENERATOR", sequenceName="SEQ_ID_CONSTANCIA ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONSTANCIA_IDCONSTANCIA_GENERATOR")
	@Column(name="ID_CONSTANCIA")
	private long idConstancia;

	private String detalle;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA")
	private Date fechaHora;

	//uni-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="ID_ESTUDIANTE")
	private Estudiante estudiante;

	//uni-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO")
	private Evento evento;

	public Constancia() {
	}

	public long getIdConstancia() {
		return this.idConstancia;
	}

	public void setIdConstancia(long idConstancia) {
		this.idConstancia = idConstancia;
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

}