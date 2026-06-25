package com.foodies1.controller;

import java.io.IOException;

import com.foodies1.dao.OrderDao;
import com.foodies1.daoimpl.OrderDaoImpl;
import com.foodies1.model.CartItem;
import com.foodies1.model.ClassCreator;
import com.foodies1.model.Orders;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        ClassCreator cart = (ClassCreator) session.getAttribute("cart");

        if (cart == null || cart.getItems().isEmpty()) {
            resp.sendRedirect("Cart.jsp");
            return;
        }

//        int id=Integer.parseInt(req.getParameter("u_id"));
        String payment = req.getParameter("payment");
        String address = req.getParameter("address");

        int total = 0;

        for (CartItem item : cart.getItems().values()) {
            total += item.getPrice() * item.getQuantity();
        }

        int deliveryFee = 40;
        int grandTotal = total + deliveryFee;

        session.setAttribute("address", address);
        session.setAttribute("payment", payment);
        session.setAttribute("grandTotal", grandTotal);
        
        Orders od = new Orders(grandTotal,payment,address);
        
       OrderDao odi = new OrderDaoImpl();
       odi.addOrder(od);

        session.removeAttribute("cart");

        resp.sendRedirect("OrderSuccess.jsp");
    }
}