package com.bigfive.beans;

import java.util.List;

import javax.ejb.Remote;

import com.bigfive.entities.Itr;

@Remote
public interface ITRBeanRemote extends ICrud<Itr> {

	List<Itr> listarElementosHabilitados();

	void actualizar();
//	boolean estaEnUso(Itr itr);

}
