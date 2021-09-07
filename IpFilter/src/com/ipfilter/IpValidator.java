package com.ipfilter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IpValidator
 */
public class IpValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getParameter("address");
		String forbiddenAddress = this.getServletConfig().getInitParameter("forbiddenIpAddress");
		
		if(address.equals(forbiddenAddress)) {
			response.sendRedirect("forbidden.jsp");
		} else {
			response.sendRedirect("success.jsp");
		}
	}

}
