package com.bigfive.beans;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Analista;

/**
 * Session Bean implementation class AnalistaBeanRemote
 */
@Stateless
public class AnalistaBeanRemote implements AnalistaBeanRemoteRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public AnalistaBeanRemote() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean crear(Analista value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR ANALISTA");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrar(Analista value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR ANALISTA");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Analista value) {
		try {
			em.merge(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR ESTUDIANTE");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Analista> listarElementos() {
		return em.createQuery("SELECT e FROM Analista e").getResultList();

	}

}
