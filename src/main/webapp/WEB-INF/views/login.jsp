<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>p{background-color:pink;font-size:40px}</style>
</head>
<body>
<div class="container">
	<h1>Login</h1>
	<p class="message">${ message }</p>
	<form action="/login-submit">
		<label>Email:</label>
		<input type="email" name="email"/><br><br>
		<label>Password:</label>
		<input type="password" name="password"/><br><br>
		<button type="submit">Login</button>
	</form>
</div>
</body>
</html>