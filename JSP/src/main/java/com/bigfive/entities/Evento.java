package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EVENTO database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTO_IDEVENTO_GENERATOR", sequenceName="SEQ_ID_EVENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTO_IDEVENTO_GENERATOR")
	@Column(name="ID_EVENTO")
	private long idEvento;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_FINAL")
	private Date fechaHoraFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_INCIO")
	private Date fechaHoraIncio;

	@Column(name="TITULO")
	private String titulo;

	public Evento() {
	}

	public long getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public Date getFechaHoraFinal() {
		return this.fechaHoraFinal;
	}

	public void setFechaHoraFinal(Date fechaHoraFinal) {
		this.fechaHoraFinal = fechaHoraFinal;
	}

	public Date getFechaHoraIncio() {
		return this.fechaHoraIncio;
	}

	public void setFechaHoraIncio(Date fechaHoraIncio) {
		this.fechaHoraIncio = fechaHoraIncio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String título) {
		this.titulo = título;
	}

	@Override
	public String toString() {
		return idEvento + "- " + titulo;
	}
	

}