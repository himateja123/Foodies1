<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Foodies - Signup</title>


</head>
<body>
    <h2>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/signup.css?v=12" />
<img src="${pageContext.request.contextPath}/images/logo.svg" alt="Foodies Logo" class="logo-img" />

        Foodies
    </h2>
    <h1>Sign Up</h1>
    <p>or <a href="Login.jsp">login to your account</a></p>

    <form action="signupservlet" method="post">

        <label>Name</label>
        <input type="text" name="name" required /><br><br>

        <label>Email</label>
        <input type="email" name="mail" required /><br><br>

        <label>Mobile Number</label>
        <input type="tel" name="phone_number" required /><br><br>

        <label>Username</label>
        <input type="text" name="username" required /><br><br>

        <label>Password</label>
        <input type="password" name="password" required /><br><br>

        <input type="submit" value="CONTINUE" />

    </form>
</body>
</html>