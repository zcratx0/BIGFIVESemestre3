package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the JUSTIFICACION database table.
 * 
 */
@Entity
@NamedQuery(name="Justificacion.findAll", query="SELECT j FROM Justificacion j")
public class Justificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JUSTIFICACION_IDJUSTIFICACION_GENERATOR", sequenceName="SEQ_ID_JUSTIFICACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JUSTIFICACION_IDJUSTIFICACION_GENERATOR")
	@Column(name="ID_JUSTIFICACION")
	private long idJustificacion;

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

	public Justificacion() {
	}

	public long getIdJustificacion() {
		return this.idJustificacion;
	}

	public void setIdJustificacion(long idJustificacion) {
		this.idJustificacion = idJustificacion;
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