package com.foodies1.controller;

import java.io.IOException;
import java.util.List;

import com.foodies1.daoimpl.RestaurantDaoImpl;
import com.foodies1.model.Restaurants;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/restaurantservlet")

public class RestaurantServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		RestaurantDaoImpl r = new RestaurantDaoImpl();
		List<Restaurants>list = r.getAll();
		
		req.setAttribute("restaurant", list);
		RequestDispatcher rd = req.getRequestDispatcher("Restaurants.jsp");
		rd.forward(req, resp);
	
	
	}
	
}
