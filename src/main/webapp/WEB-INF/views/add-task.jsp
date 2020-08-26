<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>Add a Task</h1>
<form method="post">
	<label>Description</label>
	<input type="text" name="description"/><br><br>
	<label>Date</label>
	<input type="date" name="duedate"/><br><br>
	<button type="submit">Add</button>
	<a href="/list-task">Never Mind</a>
</form>
</div>
</body>
</html>