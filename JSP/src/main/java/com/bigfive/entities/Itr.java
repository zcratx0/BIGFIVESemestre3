package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ITR database table.
 * 
 */
@Entity
@NamedQuery(name="Itr.findAll", query="SELECT i FROM Itr i")
public class Itr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ITR_IDITR_GENERATOR", sequenceName="SEQ_ID_ITR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITR_IDITR_GENERATOR")
	@Column(name="ID_ITR")
	private long idItr;

	private int estado;

	private String nombre;

	@Enumerated(EnumType.STRING)
	@Column(name="DEPARTAMENTO")
	private EnumDepartamentos enumDepartamento;
	
	
	public Itr() {
	}

	public long getIdItr() {
		return this.idItr;
	}

	public void setIdItr(long idItr) {
		this.idItr = idItr;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EnumDepartamentos getDepartamento() {
		return this.enumDepartamento;
	}

	public void setDepartamento(EnumDepartamentos departamento) {
		this.enumDepartamento = departamento;
	}

	@Override
	public String toString() {
		return this.nombre + " - " + this.enumDepartamento;
	}
	
	

}