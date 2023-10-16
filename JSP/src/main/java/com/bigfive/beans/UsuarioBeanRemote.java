package com.bigfive.beans;

import javax.ejb.Remote;

import com.bigfive.entities.Analista;
import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Tutor;
import com.bigfive.entities.Usuario;

@Remote
public interface UsuarioBeanRemote extends ICrud<Usuario> {
	public Usuario loginUsuario(String name, String password);
	public int detectarUsuario(Long usuario);
	public int getEstadoUsuario(Usuario usuario);
	Long createWithId(Usuario usuario);
	Analista getAnalista(Usuario usuario);
	Estudiante getEstudiante(Usuario usuario);
	Tutor getTutor(Usuario usuario);
	boolean habilitarUsuario(Usuario value);
	String getTipoDeUsuario(Usuario usuario);
}
