package com.foodies1.controller;

import java.io.IOException;
import java.util.List;

import com.foodies1.dao.MenuDao;
import com.foodies1.dao.RestaurantDao;
import com.foodies1.daoimpl.MenuDaoImpl;
import com.foodies1.daoimpl.RestaurantDaoImpl;
import com.foodies1.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int rid = Integer.parseInt(req.getParameter("restaurant_id").trim());
		
		
		
		MenuDao mdi=new MenuDaoImpl();
		List<Menu> menuList =  mdi.getMenu(rid);
		
		req.setAttribute("menus", menuList);
		
		RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
		rd.forward(req, resp);
	
	}
	
}
