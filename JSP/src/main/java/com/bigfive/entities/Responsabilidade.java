package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RESPONSABILIDADES database table.
 * 
 */
@Entity
@Table(name="RESPONSABILIDADES")
@NamedQuery(name="Responsabilidade.findAll", query="SELECT r FROM Responsabilidade r")
public class Responsabilidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESPONSABILIDADES_IDRESPONSABILIDADES_GENERATOR", sequenceName="SEQ_ID_RESPONSABILIDADES ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESPONSABILIDADES_IDRESPONSABILIDADES_GENERATOR")
	@Column(name="ID_RESPONSABILIDADES")
	private long idResponsabilidades;

	//uni-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO")
	private Evento evento;

	//uni-directional many-to-one association to Tutor
	@ManyToOne
	@JoinColumn(name="ID_TUTOR")
	private Tutor tutor;

	public Responsabilidade() {
	}

	public long getIdResponsabilidades() {
		return this.idResponsabilidades;
	}

	public void setIdResponsabilidades(long idResponsabilidades) {
		this.idResponsabilidades = idResponsabilidades;
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

}