package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TUTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Tutor.findAll", query="SELECT t FROM Tutor t")
public class Tutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TUTOR_IDTUTOR_GENERATOR", sequenceName="SEQ_ID_TUTOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TUTOR_IDTUTOR_GENERATOR")
	@Column(name="ID_TUTOR")
	private long idTutor;

	//bi-directional many-to-one association to Reclamo
	@OneToMany(mappedBy="tutor")
	private List<Reclamo> reclamos;

	//uni-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="ID_AREA")
	private Area area;

	//uni-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Rol rol;


	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Tutor() {
	}

	public long getIdTutor() {
		return this.idTutor;
	}

	public void setIdTutor(long idTutor) {
		this.idTutor = idTutor;
	}

	public List<Reclamo> getReclamos() {
		return this.reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	public Reclamo addReclamo(Reclamo reclamo) {
		getReclamos().add(reclamo);
		reclamo.setTutor(this);

		return reclamo;
	}

	public Reclamo removeReclamo(Reclamo reclamo) {
		getReclamos().remove(reclamo);
		reclamo.setTutor(null);

		return reclamo;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return usuario.getNombre() + " " + usuario.getApellido();
	}
	
	
	
}