package com.foodies1.controller;

import java.io.IOException;

import com.foodies1.daoimpl.UserDaoImpl;
import com.foodies1.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String phone = req.getParameter("phone_number");
        String password = req.getParameter("password");

        try {
            UserDaoImpl userDao = new UserDaoImpl();
            Users user = userDao.getUser(phone);

            if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
                req.getSession().setAttribute("name", user.getName());
                resp.sendRedirect(req.getContextPath() + "/restaurantservlet");
                return;
            }

            req.setAttribute("loginError", "Invalid mobile number or password. Please try again.");
            req.getRequestDispatcher("/Login.jsp").forward(req, resp);
        } catch (IllegalStateException ex) {
            log("Foodies login could not connect to the database.", ex);
            req.setAttribute("loginError", "Login is temporarily unavailable. Please try again later.");
            req.getRequestDispatcher("/Login.jsp").forward(req, resp);
        }
    }
}
