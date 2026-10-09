<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.foodies1.model.ClassCreator"%>
<%@page import="com.foodies1.model.CartItem"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Foodies Cart</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/cart.css?v=1" />

</head>

<body>

	<h1>Your Cart</h1>

	<%
	ClassCreator cart = (ClassCreator) session.getAttribute("cart");

	if (cart == null || cart.getItems().isEmpty()) {
	%>

	<h2>Your cart is empty</h2>

	<%
	} else {

	Map<Integer, CartItem> cartItems = cart.getItems();

	for (CartItem item : cartItems.values()) {
	%>

	<div>
		<img src="${pageContext.request.contextPath}/<%=item.getImagePath()%>"
			alt="<%=item.getItemName()%>" width="150" />

		<h2><%=item.getItemName()%></h2>

		<p>
			Price: ₹<%=item.getPrice()%></p>

		<p>
			Quantity:
			<%=item.getQuantity()%></p>

		<!-- Update quantity -->
		<form action="cart" method="post">
			<input type="hidden" name="action" value="update" /> <input
				type="hidden" name="menu_id" value="<%=item.getMenu_id()%>" /> <input
				type="number" name="quantity" value="<%=item.getQuantity()%>"
				min="1" />

			<button type="submit">Update</button>
		</form>

		<!-- Delete item -->
		<form action="cart" method="post">
			<input type="hidden" name="action" value="delete" /> <input
				type="hidden" name="menu_id" value="<%=item.getMenu_id()%>" />

			<button type="submit">Delete</button>
		</form>

	</div>

	<hr />

	<%
	}
	}
	%>

	<a href="restaurantservlet"><button type="button">ADD MORE ITEMS</button> </a>
	<br />
	<br />
	<a href="Checkout.jsp">
		<button type="button">Proceed To Checkout</button>
	</a>

</body>
</html>