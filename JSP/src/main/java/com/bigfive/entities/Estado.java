package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ESTADO database table.
 * 
 */
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADO_IDESTADO_GENERATOR", sequenceName="SEQ_ID_ESTADO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADO_IDESTADO_GENERATOR")
	@Column(name="ID_ESTADO")
	private long idEstado;

	private String nombre;
	
	private int estado;

	public Estado() {
	}

	public long getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getEstado() {
		return estado > 0 ? true: false;
		
	}

	public void setEstado(boolean estado) {
		this.estado = estado ? 1 : 0 ;
		
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	

}