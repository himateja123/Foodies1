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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/Login.jsp");
            return;
        }

        ClassCreator cart = (ClassCreator) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/Cart.jsp");
            return;
        }

        String payment = req.getParameter("payment");
        String address = req.getParameter("address");
        if (payment == null || payment.isBlank() || address == null || address.isBlank()) {
            req.setAttribute("checkoutError", "Please enter a delivery address and choose a payment method.");
            req.getRequestDispatcher("/Checkout.jsp").forward(req, resp);
            return;
        }

        int total = 0;
        for (CartItem item : cart.getItems().values()) {
            total += item.getPrice() * item.getQuantity();
        }
        int grandTotal = total + 40;

        try {
            Orders order = new Orders(grandTotal, payment, address);
            OrderDao orderDao = new OrderDaoImpl();
            int saved = orderDao.addOrder(order);

            if (saved <= 0) {
                req.setAttribute("checkoutError", "We couldn't save your order. Your cart is still available; please try again.");
                req.getRequestDispatcher("/Checkout.jsp").forward(req, resp);
                return;
            }

            session.setAttribute("address", address);
            session.setAttribute("payment", payment);
            session.setAttribute("grandTotal", grandTotal);
            session.removeAttribute("cart");
            resp.sendRedirect(req.getContextPath() + "/OrderSuccess.jsp");
        } catch (IllegalStateException ex) {
            log("Foodies checkout could not connect to the database.", ex);
            req.setAttribute("checkoutError", "Ordering is temporarily unavailable because the database could not be reached. Your cart is still available.");
            req.getRequestDispatcher("/Checkout.jsp").forward(req, resp);
        }
    }
}
