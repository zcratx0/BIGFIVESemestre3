package com.bigfive.beans;

import java.util.List;
import javax.ejb.Remote;

import com.bigfive.entities.Genero;

@Remote
public interface GeneroBeanRemote extends ICrud<Genero>{

    List<Genero> listarElementos();
    void actualizar();

}
