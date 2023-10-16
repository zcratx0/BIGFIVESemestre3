package com.bigfive.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AREA database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AREA_IDAREA_GENERATOR", sequenceName="SEQ_ID_AREA ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREA_IDAREA_GENERATOR")
	@Column(name="ID_AREA")
	private long idArea;

	private String area;

	public Area() {
	}

	public long getIdArea() {
		return this.idArea;
	}

	public void setIdArea(long idArea) {
		this.idArea = idArea;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return idArea + "- " + area;
	}
	
	

}