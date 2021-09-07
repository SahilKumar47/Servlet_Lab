package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String configUsername;
	private String configPassword;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		configUsername = config.getInitParameter("username");
		configPassword = config.getInitParameter("password");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		out.print(configPassword);
		if (username.equals(configUsername) && password.equals(configPassword)) {
			out.print("You are logged in");
		} else {
			int counter = Integer.parseInt(this.getServletContext().getInitParameter("counter"));
			while (counter > 0) {
				out.print("Invalid username " + username + " and password " + password + "<br/>");
				counter--;
			}
		}
	}

}
