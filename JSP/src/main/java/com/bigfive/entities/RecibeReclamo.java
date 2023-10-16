package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RECIBE_RECLAMO database table.
 * 
 */
@Entity
@Table(name="RECIBE_RECLAMO")
@NamedQuery(name="RecibeReclamo.findAll", query="SELECT r FROM RecibeReclamo r")
public class RecibeReclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECIBE_RECLAMO_IDRECIBERE_GENERATOR", sequenceName="SEQ_ID_RECIBE_RE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECIBE_RECLAMO_IDRECIBERE_GENERATOR")
	@Column(name="ID_RECIBE_RE")
	private long idRecibeRe;

	//uni-directional many-to-one association to Accione
	@ManyToOne
	@JoinColumn(name="ID_ACCIONES")
	private Accione accione;

	//uni-directional many-to-one association to Reclamo
	@ManyToOne
	@JoinColumn(name="ID_RECLAMO")
	private Reclamo reclamo;

	public RecibeReclamo() {
	}

	public long getIdRecibeRe() {
		return this.idRecibeRe;
	}

	public void setIdRecibeRe(long idRecibeRe) {
		this.idRecibeRe = idRecibeRe;
	}

	public Accione getAccione() {
		return this.accione;
	}

	public void setAccione(Accione accione) {
		this.accione = accione;
	}

	public Reclamo getReclamo() {
		return this.reclamo;
	}

	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}

}