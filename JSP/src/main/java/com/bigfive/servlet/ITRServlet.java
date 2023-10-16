package com.bigfive.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigfive.beans.ITRBean;
import com.bigfive.beans.ITRBeanRemote;

/**
 * Servlet implementation class ITRServlet
 */
@WebServlet("/ITRServlet")
public class ITRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ITRBeanRemote itrBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ITRServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("itrList", itrBean.listarElementos());
		request.getRequestDispatcher("/ListaITR.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
