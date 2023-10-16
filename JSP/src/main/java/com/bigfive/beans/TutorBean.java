package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Tutor;

import com.bigfive.entities.Tutor;

/**
 * Session Bean implementation class TutorBean
 */
@Stateless
public class TutorBean implements TutorBeanRemote {
	
	@PersistenceContext
	EntityManager em;
    
	@Override
	public boolean crear(Tutor value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.out.println("ERROR AL CREAR TUTOR: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean borrar(Tutor value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.out.println("ERROR AL BORRAR TUTOR: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean modificar(Tutor value) {
		try {
			em.merge(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.out.println("ERROR AL MODIFICAR TUTOR: " + e.getMessage());
		}
		return false;
	}

	@Override
	public List<Tutor> listarElementos() {
		System.out.println("listanod tutores");
		return em.createQuery("SELECT t FROM Tutor t").getResultList();
	}

    
}
