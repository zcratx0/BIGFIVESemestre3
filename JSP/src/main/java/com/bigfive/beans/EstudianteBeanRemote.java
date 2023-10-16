package com.bigfive.beans;

import javax.ejb.Remote;

import com.bigfive.entities.Estudiante;

@Remote
public interface EstudianteBeanRemote extends ICrud<Estudiante>{

}
