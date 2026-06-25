package com.foodies1.controller;

import java.io.IOException;

import com.foodies1.dao.MenuDao;
import com.foodies1.daoimpl.MenuDaoImpl;
import com.foodies1.model.ClassCreator;
import com.foodies1.model.CartItem;
import com.foodies1.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("add".equals(action)) {

            int menuId = Integer.parseInt(
                    req.getParameter("menu_id").trim()
            );

            MenuDao menuDao = new MenuDaoImpl();
            Menu menu = menuDao.getMenuById(menuId);

            if (menu == null) {
                resp.getWriter().println("Menu item not found");
                return;
            }

            HttpSession session = req.getSession();

            ClassCreator cart = 
                    (ClassCreator) session.getAttribute("cart");

            if (cart == null) {
                cart = new ClassCreator();
            }

            CartItem item = new CartItem(
                    menu.getMenu_id(),
                    menu.getItemName(),
                    menu.getImagePath(),
                    menu.getPrice(),
                    1
            );

            cart.addCartItem(item);

            session.setAttribute("cart", cart);

            resp.sendRedirect("Cart.jsp");
            return;
        }
        
        
        if("update".equals(action)) {
        	
        		int mid=Integer.parseInt(req.getParameter("menu_id").trim());
        		int quant=Integer.parseInt(req.getParameter("quantity").trim());
        		
        		HttpSession session = req.getSession();

                ClassCreator cart = 
                        (ClassCreator) session.getAttribute("cart");
                
                cart.updateCartItem(mid, quant);
                
                session.setAttribute("cart", cart);

                resp.sendRedirect("Cart.jsp");
                return;
        }
        
        if("delete".equals(action)) {
        	
    		int mid=Integer.parseInt(req.getParameter("menu_id").trim());
    		
    		HttpSession session = req.getSession();

            ClassCreator cart = 
                    (ClassCreator) session.getAttribute("cart");
            
            cart.deleteCartItem(mid);
            
            session.setAttribute("cart", cart);

            resp.sendRedirect("Cart.jsp");
            return;
    }
    } 
}