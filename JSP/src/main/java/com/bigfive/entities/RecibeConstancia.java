package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RECIBE_CONSTANCIA database table.
 * 
 */
@Entity
@Table(name="RECIBE_CONSTANCIA")
@NamedQuery(name="RecibeConstancia.findAll", query="SELECT r FROM RecibeConstancia r")
public class RecibeConstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECIBE_CONSTANCIA_IDRECIBECON_GENERATOR", sequenceName="SEQ_ID_RECIBE_CON ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECIBE_CONSTANCIA_IDRECIBECON_GENERATOR")
	@Column(name="ID_RECIBE_CON")
	private long idRecibeCon;

	//uni-directional many-to-one association to Accione
	@ManyToOne
	@JoinColumn(name="ID_ACCIONES")
	private Accione accione;

	//uni-directional many-to-one association to Constancia
	@ManyToOne
	@JoinColumn(name="ID_CONSTANCIA")
	private Constancia constancia;

	public RecibeConstancia() {
	}

	public long getIdRecibeCon() {
		return this.idRecibeCon;
	}

	public void setIdRecibeCon(long idRecibeCon) {
		this.idRecibeCon = idRecibeCon;
	}

	public Accione getAccione() {
		return this.accione;
	}

	public void setAccione(Accione accione) {
		this.accione = accione;
	}

	public Constancia getConstancia() {
		return this.constancia;
	}

	public void setConstancia(Constancia constancia) {
		this.constancia = constancia;
	}

}