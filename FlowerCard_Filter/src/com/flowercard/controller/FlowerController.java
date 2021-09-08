package com.flowercard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FlowerController
 */
@WebServlet("/FlowerController")
public class FlowerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flowersQuantity = Integer.valueOf(request.getParameter("flowersQuantity"));
		HttpSession session = request.getSession();		
		session.setAttribute("flowersQuantity", flowersQuantity);
		response.sendRedirect("home.jsp");
	}

}
