package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GESTION database table.
 * 
 */
@Entity
@NamedQuery(name="Gestion.findAll", query="SELECT g FROM Gestion g")
public class Gestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GESTION_IDGESTION_GENERATOR", sequenceName="SEQ_ID_GESTION ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GESTION_IDGESTION_GENERATOR")
	@Column(name="ID_GESTION")
	private long idGestion;

	//uni-directional many-to-one association to Analista
	@ManyToOne
	@JoinColumn(name="ID_ANALISTA")
	private Analista analista;

	//uni-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO")
	private Evento evento;

	public Gestion() {
	}

	public long getIdGestion() {
		return this.idGestion;
	}

	public void setIdGestion(long idGestion) {
		this.idGestion = idGestion;
	}

	public Analista getAnalista() {
		return this.analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}