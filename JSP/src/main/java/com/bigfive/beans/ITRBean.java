package com.bigfive.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bigfive.entities.Itr;

/**
 * Session Bean implementation class ITRBean
 */
@Singleton
@Startup
public class ITRBean implements ITRBeanRemote {
	@PersistenceContext
	EntityManager em;
	
	private List<Itr> itrs;
	
    /**
     * Default constructor. 
     */
    public ITRBean() {}
    
    @PostConstruct
    public void init() {
    	System.out.println("CARGANDO ITR'S DE LA BASE DE DATOS");
    	this.itrs = new ArrayList<>();
    	this.itrs = em.createQuery("SELECT u FROM Itr u").getResultList();
    	this.itrs.forEach(i -> {
    		System.out.println("ITR: " + i.getIdItr() + " - " + i.getNombre() + " - " +i.getEstado() + " - " /*+ estaEnUso(i)*/);
    	});
    }
    

    @PreDestroy
    public void destroy() {
    	System.out.println("ITRBean termina");
    }
    

	@Override
	public boolean crear(Itr value) {
		try {
			em.persist(value);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrar(Itr value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Itr value) {
		try {
			em.merge(value);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Itr> listarElementos() {
		return this.itrs;
	}
	@Override
	public List<Itr> listarElementosHabilitados() {
		List<Itr> habilitados = new ArrayList<>();
		this.itrs.forEach(i -> {
			if (i.getEstado() != 0) {
				habilitados.add(i);
			}
		});
		return habilitados;
	}
	
	@Override
	public void actualizar() {
		this.itrs = em.createQuery("SELECT u FROM Itr u").getResultList();
	}
	/*
	@Override
	public boolean estaEnUso(Itr itr) {
		return em.createQuery("SELECT u FROM Usuario u WHERE u.itr LIKE :itr").setParameter("itr", itr).getResultList().size() > 0 ? true : false;
	}
	*/
}
