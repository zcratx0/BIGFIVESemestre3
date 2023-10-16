package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ANALISTA database table.
 * 
 */
@Entity
@NamedQuery(name="Analista.findAll", query="SELECT a FROM Analista a")
public class Analista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANALISTA_IDANALISTA_GENERATOR", sequenceName="SEQ_ID_ANALISTA ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANALISTA_IDANALISTA_GENERATOR")
	@Column(name="ID_ANALISTA")
	private long idAnalista;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Analista() {
	}

	public long getIdAnalista() {
		return this.idAnalista;
	}

	public void setIdAnalista(long idAnalista) {
		this.idAnalista = idAnalista;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}