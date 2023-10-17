package com.bigfive.servlet;

import java.io.IOException;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigfive.beans.AnalistaBeanRemoteRemote;
import com.bigfive.beans.EstudianteBeanRemote;
import com.bigfive.beans.ITRBeanRemote;
import com.bigfive.beans.TutorBeanRemote;
import com.bigfive.beans.UsuarioBeanRemote;

/**
 * Servlet implementation class ITRServlet
 */
@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UsuarioBeanRemote userBean;
	@EJB
	private EstudianteBeanRemote estBean;
	@EJB
	private TutorBeanRemote tutBean;
	@EJB
	private AnalistaBeanRemoteRemote anaBean;
    public UsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("estList", estBean.listarElementos());
		request.setAttribute("tutList", tutBean.listarElementos());
		request.setAttribute("anaList", anaBean.listarElementos());
		request.getRequestDispatcher("/listausuarios.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
