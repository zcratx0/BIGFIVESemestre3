package com.bigfive.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Estudiante;

import com.bigfive.entities.Estudiante;

/**
 * Session Bean implementation class EstudianteBean
 */
@Stateless
public class EstudianteBean implements EstudianteBeanRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public EstudianteBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public boolean crear(Estudiante value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR ESTUDIANTE");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrar(Estudiante value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR ESTUDIANTE");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Estudiante value) {
		try {
			em.persist(value);
			em.flush();
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR ESTUDIANTE");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Estudiante> listarElementos() {
		return em.createQuery("SELECT e FROM Estudiante e").getResultList();
	}

}
