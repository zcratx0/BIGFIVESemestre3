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

import com.bigfive.beans.ITRBeanRemote;

/**
 * Servlet implementation class ITRServlet
 */
@WebServlet("/ITRServlet")
@RolesAllowed("ANALISTA")
public class ITRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ITRBeanRemote itrBean;
    public ITRServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setAttribute("itrList", itrBean.listarElementos());
		request.getRequestDispatcher("/ListaITR.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
