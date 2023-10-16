package com.bigfive.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bigfive.entities.Analista;
import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Tutor;
import com.bigfive.entities.Usuario;
//import com.bigfive.utils.Mail;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class UsuarioBean implements UsuarioBeanRemote {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UsuarioBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean crear(Usuario usuario) {
		try {
			em.persist(usuario);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR USUARIO " + usuario.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrar(Usuario value) {
		try {
			em.remove(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL BORRAR USUARIO " + value.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Usuario value) {
		try {
			em.merge(value);
			em.flush();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR Usuario " + value.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Usuario> listarElementos() {
		return em.createQuery("SELECT u FROM Usuario u").getResultList();
	}

	@Override
	public Usuario loginUsuario(String name, String password) {
		Usuario x = null;
		x = (Usuario) em.createQuery(
				"SELECT u FROM Usuario u WHERE SUBSTRING(u.mailInstitucional, 1, LOCATE('@', u.mailInstitucional) - 1) LIKE :name AND u.contrasenia = :password")
				.setParameter("name", name).setParameter("password", password).getSingleResult();
		System.out.println(x);
		return x;
	}

	@Override
	public int detectarUsuario(Long usuario) {
		Analista analista = null;
		try {
			analista = (Analista) em.createQuery("SELECT a FROM Analista a WHERE a.usuario.id = :user")
					.setParameter("user", usuario).getSingleResult();
			if (analista != null) {
				return 0;
			}
		} catch (Exception e) {
			try {
				Tutor tutor = null;
				tutor = (Tutor) em.createQuery("SELECT t FROM Tutor t WHERE t.usuario.id = :user")
						.setParameter("user", usuario).getSingleResult();
				if (tutor != null) {
					return 1;
				}
			} catch (Exception e1) {
				try {
					Estudiante estudiante = null;
					estudiante = (Estudiante) em.createQuery("SELECT e FROM Estudiante e WHERE e.usuario.id = :user")
							.setParameter("user", usuario).getSingleResult();
					if (estudiante != null) {
						return 2;
					}
				} catch (Exception e2) {
					return -1;
				}
			}
		}
		return -1;
	}

	@Override
	public int getEstadoUsuario(Usuario usuario) {
		// Obtiene el estado del Usuario
		int estado;
		estado = (int) em.createQuery("SELECT u.estado FROM Usuario u WHERE u.estado = :user")
				.setParameter("user", usuario).getSingleResult();
		return estado;
	}

	@Override
	public Long createWithId(Usuario usuario) {
		String msgCreacion = "<b>" + usuario.getNombre().toUpperCase()
				+ "!</b><br>Estamos procesando tu solicitud de inscripción!<br>Cuando este terminada te notificaremos.";
		try {
			em.persist(usuario);
			em.flush();
//			Mail.sendMail(usuario.getMail(), "Creación de Usuario", msgCreacion);
			return (Long) usuario.getIdUsuario();
		} catch (Exception e) {
			System.err.println("ERROR AL CREAR USUARIO " + usuario.toString());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean habilitarUsuario(Usuario value) {
		String msgHabilitado = "<h2>" + value.getNombre().toUpperCase() + " " + value.getApellido().toUpperCase()
				+ " ¡Ahora formas parte de UTEC!</h2>"
				+ "<br><br>Tras revisar tu documentación, le confirmamos que la misma ha sido <b>validada completamente</b>."
				+ "<br><br>Mediante este correo te estamos haciendo llegar tu usuario y contraseña para el acceso a tu cuenta de Correo Institucional."
				+ "<br><br><b>Email: </b>" + value.getMailInstitucional() + "<br><b>Contraseña: "
				+ value.getContrasenia();
		String msgBorrado = "<h2>" + value.getNombre().toUpperCase() + " " + value.getApellido().toUpperCase()
				+ " ¡Ya no eres parte de UTEC!"
				+ "<br><br>Tras revisar tu documentación, le informamos que la misma <b>no cumple los requisitos necesarios</b>.";
		if (value.getEstado() == 1) {
//			Mail.sendMail(value.getMail(), "REGISTRO UTEC", msgHabilitado);
		} else if (value.getEstado() == 2) {
//			Mail.sendMail(value.getMail(), "REGISTRO UTEC", msgBorrado);
		}
		return modificar(value);
	}

	@Override
	public Analista getAnalista(Usuario usuario) {
		return (Analista) em.createQuery("SELECT a FROM Analista a WHERE a.usuario.id = :user")
				.setParameter("user", usuario.getIdUsuario()).getSingleResult();
	}

	@Override
	public Estudiante getEstudiante(Usuario usuario) {
		return (Estudiante) em.createQuery("SELECT e FROM Estudiante e WHERE e.usuario.id = :user")
				.setParameter("user", usuario.getIdUsuario()).getSingleResult();
	}

	@Override
	public Tutor getTutor(Usuario usuario) {
		return (Tutor) em.createQuery("SELECT t FROM Tutor t WHERE t.usuario.id = :user")
				.setParameter("user", usuario.getIdUsuario()).getSingleResult();
	}
	
	@Override
	public String getTipoDeUsuario(Usuario usuario) {
		String tipo = "";
		try {
			if (em.createQuery("SELECT a FROM Analista a WHERE a.usuario.id = :user")
					.setParameter("user", usuario.getIdUsuario()).getResultList().size() > 0) {
				tipo += "analista,";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			if (em.createQuery("SELECT t FROM Tutor t WHERE t.usuario.id = :user")
					.setParameter("user", usuario.getIdUsuario()).getResultList().size() > 0) {
				tipo += "tutor,";
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		try {
			
			if (em.createQuery("SELECT e FROM Estudiante e WHERE e.usuario.id = :user")
					.setParameter("user", usuario.getIdUsuario()).getResultList().size() > 0) {
				tipo += "estudiante";
			}
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return tipo;
	}

}
