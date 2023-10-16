package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CONVOCATORIA_ASISTENCIA database table.
 * 
 */
@Entity
@Table(name="CONVOCATORIA_ASISTENCIA")
@NamedQuery(name="ConvocatoriaAsistencia.findAll", query="SELECT c FROM ConvocatoriaAsistencia c")
public class ConvocatoriaAsistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONVOCATORIA_ASISTENCIA_IDCONVOCATORIAASISTENCIA_GENERATOR", sequenceName=" SEQ_ID_CONVOCATORIA_ASISTENCIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONVOCATORIA_ASISTENCIA_IDCONVOCATORIAASISTENCIA_GENERATOR")
	@Column(name="ID_CONVOCATORIA_ASISTENCIA")
	private long idConvocatoriaAsistencia;

	private String asistencia;

	private BigDecimal calificacion;

	//uni-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="ID_ESTUDIANTE")
	private Estudiante estudiante;

	//uni-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO")
	private Evento evento;

	public ConvocatoriaAsistencia() {
	}

	public long getIdConvocatoriaAsistencia() {
		return this.idConvocatoriaAsistencia;
	}

	public void setIdConvocatoriaAsistencia(long idConvocatoriaAsistencia) {
		this.idConvocatoriaAsistencia = idConvocatoriaAsistencia;
	}

	public String getAsistencia() {
		return this.asistencia;
	}

	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}

	public BigDecimal getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
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