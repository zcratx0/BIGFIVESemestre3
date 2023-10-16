package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ESTUDIANTE database table.
 * 
 */
@Entity
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTUDIANTE_IDESTUDIANTE_GENERATOR", sequenceName="SEQ_ID_ESTUDIANTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTUDIANTE_IDESTUDIANTE_GENERATOR")
	@Column(name="ID_ESTUDIANTE")
	private long idEstudiante;

	private String generacion;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Estudiante() {
	}

	public long getIdEstudiante() {
		return this.idEstudiante;
	}

	public void setIdEstudiante(long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getGeneracion() {
		return this.generacion;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}