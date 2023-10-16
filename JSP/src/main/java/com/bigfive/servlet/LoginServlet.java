package com.bigfive.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigfive.beans.UsuarioBeanRemote;
import com.bigfive.entities.Usuario;
import com.bigfive.funciones.BFJWT;

/**
 * Servlet implementation class LoginServerlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UsuarioBeanRemote usuarioBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Usuario user = null;
		try {
			user = usuarioBean.loginUsuario(username, password);
		} catch (Exception e) {
			
		}
		response.getWriter().append("Served at: "+user + " " + username + " " + password ).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			user = usuarioBean.loginUsuario(username, password);
		} catch (Exception e) {}
		if (user != null) {
			response.getWriter().write(BFJWT.createToken(user));
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Credenciales invalidas!");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		doGet(request, response);
	}

	private String generarJWT(String username) {
		String token = "";
		String key = "BooggysayHi";
		return token;
	}
	
}
