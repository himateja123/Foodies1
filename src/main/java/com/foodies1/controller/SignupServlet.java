package com.foodies1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.foodies1.daoimpl.UserDaoImpl;
import com.foodies1.model.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signupservlet")

public class SignupServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name =req.getParameter("name");
		String mail =req.getParameter("mail");
		String phone =req.getParameter("phone_number");
		String un =req.getParameter("username");
		String password =req.getParameter("password");
		
		Users user =new Users(name,mail,phone,un,password,null);
		
		UserDaoImpl udi = new UserDaoImpl();
		int x=udi.addUser(user);
		if(x!=0) {
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
		else {
			PrintWriter out = resp.getWriter();
			out.print("signup Failed");
		}
	}
}
