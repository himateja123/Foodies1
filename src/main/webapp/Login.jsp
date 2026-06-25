<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Foodies - Login</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/login.css?v=14" />



</head>
<body>
    <h2>
		<img src="${pageContext.request.contextPath}/images/logo.svg" alt="Foodies Logo" class="logo-img" />
		
        Foodies
    </h2>
    <h1>Login</h1>
    <p>or <a href="SignUp.jsp">Create an account</a></p>

    <form action="loginservlet" method="post">

        <label>Mobile Number</label>
        <input type="tel" name="phone_number" required /><br><br>

        <label>Password</label>
        <input type="password" name="password" required /><br><br>

        <input type="submit" value="LOGIN" />

    </form>
</body>
</html>