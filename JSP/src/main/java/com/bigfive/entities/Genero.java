package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GENERO database table.
 * 
 */
@Entity
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GENERO_IDGENERO_GENERATOR", sequenceName="SEQ_ID_GENERO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENERO_IDGENERO_GENERATOR")
	@Column(name="ID_GENERO")
	private long idGenero;

	private String genero;

	public Genero() {
	}

	public long getIdGenero() {
		return this.idGenero;
	}

	public void setIdGenero(long idGenero) {
		this.idGenero = idGenero;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return genero;
	}

}