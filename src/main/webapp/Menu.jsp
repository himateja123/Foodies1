<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.foodies1.model.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Foodies Menu</title>
<link rel="stylesheet" type="text/css" href="/Foodies1/CSS/menu.css?v=1" />
</head>

<body>

	<div class="menu-header">
		<a href="restaurantservlet" class="back-link">← Back</a>
		<h1>Restaurant Menu</h1>
	</div>

	<div class="menu-container">

		<%
List<Menu> menulist = (List<Menu>)request.getAttribute("menus");

for(Menu m : menulist){
%>

		<div class="menu-card">
			<img src="/Foodies1/<%= m.getImagePath()%>"
				alt="<%= m.getItemName() %>" />

			<div class="menu-content">
				<div class="menu-top">
					<h2><%= m.getItemName() %></h2>
					<span class="rating">⭐ <%= m.getRatings() %></span>
				</div>

				<p class="description"><%= m.getDescription() %></p>

				<div class="menu-bottom">
					<p class="price">
						₹<%= m.getPrice() %></p>
					<form action="cart" method="post">
						<input type="hidden" name="action" value="add" /> <input
							type="hidden" name="menu_id" value="<%= m.getMenu_id() %>" />

						<button type="submit">Add</button>
					</form>
				</div>
			</div>
		</div>
		
		<%
}
%>

	</div>

</body>
</html>