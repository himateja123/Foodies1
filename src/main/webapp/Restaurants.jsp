<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.foodies1.model.Restaurants"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/restaurants.css?v=10" />
<title>Foodies Restaurants</title>
</head>

<body>

<%
String name = (String) session.getAttribute("name");
%>

	<div class="header">

    <div class="left">
        <% if(name != null) { %>
            <h2>Welcome, <%= name %></h2>
        <% } else { %>
            <h2>Welcome to Foodies</h2>
        <% } %>
    </div>

    <div class="center">
        <img src="${pageContext.request.contextPath}/images/logo.svg" class="logo-img" alt="Foodies Logo" />
        <h1 class="main-title">Top Restaurants in Vijayawada</h1>
    </div>

    <div class="right">
        <a href="Cart.jsp" class="cart-btn">Cart</a>

        <% if(name != null) { %>
            <a href="logoutservlet" class="signup-btn">Sign Out</a>
        <% } else { %>
            <a href="Login.jsp">Login</a>
            <a href="SignUp.jsp" class="signup-btn">Signup</a>
        <% } %>
    </div>

</div>

	<div class="container">

<%
List<Restaurants> list =
(List<Restaurants>)request.getAttribute("restaurant");

for(Restaurants r : list){
%>

		<a href="menu?restaurant_id=<%= r.getRestaurant_id() %>"
			class="card-link">
			<div class="card">

				<img src="${pageContext.request.contextPath}/<%= r.getImagePath() %>"
					alt="<%= r.getName() %>" />

				<div class="card-content">

					<h3><%= r.getName() %></h3>

					<p class="cuisine">
						<%= r.getCuisineType() %>
					</p>

					<p class="rating">
						⭐
						<%= r.getRatings() %>
					</p>

				</div>

			</div>
		</a>

		<%
}
%>

	</div>

</body>
</html>