package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Genero;

/**
 * Session Bean implementation class GeneroBean
 */
@Stateless
public class GeneroBean implements GeneroBeanRemote {
    @PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GeneroBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public boolean crear(Genero value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR GENERO");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean borrar(Genero value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR GENERO");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean modificar(Genero value) {
		try {
			em.persist(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR GENERO");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Genero> listarElementos() {
		return em.createQuery("SELECT e FROM Genero e").getResultList();
	}
	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
	}

}
