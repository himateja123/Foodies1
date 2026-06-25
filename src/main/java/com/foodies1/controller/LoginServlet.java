package com.foodies1.controller;

import java.io.IOException;

import com.foodies1.daoimpl.UserDaoImpl;
import com.foodies1.model.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone =req.getParameter("phone_number");
		String password =req.getParameter("password");
//		String name=req.getParameter("name");
		
//		req.getSession().setAttribute("name", name);
//		resp.sendRedirect("restaurantservlet");

		
		resp.setContentType("text/html");
		
		UserDaoImpl udi = new UserDaoImpl();
		Users user =udi.getUser(phone);
		
		if(user!=null && user.getPassword().equals(password)) {
			
			req.getSession().setAttribute("name", user.getName());
			resp.sendRedirect("restaurantservlet");
			return;
		}
		else {
			resp.getWriter().println("<p style='color:red; font-weight:bold;'>Invalid credentials, please check and enter the correct details...</p>");

			RequestDispatcher Rd = req.getRequestDispatcher("Login.jsp");
			Rd.include(req, resp);
			return;
		}
	}
	
}
