<%@page import="com.foodies1.model.ClassCreator"%>
<%@page import="com.foodies1.model.CartItem"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHCECKOUT</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/checkout.css?v=1" />

</head>
<body>

<h1>SECURE CHCECKOUT</h1>

<% if (request.getAttribute("checkoutError") != null) { %>
    <p style="color:red; font-weight:bold;"><%= request.getAttribute("checkoutError") %></p>
<% } %>

<%
ClassCreator cart = (ClassCreator) session.getAttribute("cart");

if(cart == null || cart.getItems().isEmpty()) {
%>
    <h2>Your cart is empty</h2>
    <a href="restaurantservlet">Go Back</a>
<%
} else {
    int total = 0;
    for(CartItem item : cart.getItems().values()) {
        total += item.getPrice() * item.getQuantity();
    }

    int deliveryFee = 40;
    int grandTotal = total + deliveryFee;
%>

<h2>Order Summary</h2>

<%
for(CartItem item : cart.getItems().values()) {
%>
    <div>
    <img src="${pageContext.request.contextPath}/<%=item.getImagePath()%>"
			alt="<%=item.getItemName()%>" width="150" />
        <h3><%= item.getItemName() %></h3>
        <p>Price: ₹<%= item.getPrice() %></p>
        <p>Quantity: <%= item.getQuantity() %></p>
        <p>Total: ₹<%= item.getPrice() * item.getQuantity() %></p>
    </div>
    <hr>
<%
}
%>
<h3>Items Total: ₹<%= total %></h3>
<h3>Delivery Fee: ₹<%= deliveryFee %></h3>
<h2>Grand Total: ₹<%= grandTotal %></h2>

<form action="checkout" method="post">

    <label>Delivery Address</label><br>
    <textarea name="address" rows="4" cols="40" required></textarea>
    <br><br>

    <label>Payment Method</label><br>
    <select name="payment" required>
        <option value="Cash on Delivery">Cash on Delivery</option>
        <option value="UPI">UPI</option>
        <option value="Card">Card</option>
    </select>
    <br><br>

    <button type="submit">Place Order</button>

</form>

<%
}
%>

</body>
</html>