<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />

</head>
<body>
	<div class="container">
	  <h1>My Tasks</h1>
	  <table class="table">
	  	<form action="/search-by-name">
	  		<label>Search By Description:&nbsp;</label>
	  		<input type="text" name="description"/>
	  		<button type="submit">Check</button>
	  	</form>
	  	&nbsp;&nbsp;&nbsp;&nbsp;
	  	<form action="/search-by-completion">
	  		<label>Search By Completion Status:&nbsp;</label>
	  		<input text="text" name="complete_status" value="Complete/Incomplete"/>
	  		<button type="submit">Check</button>
	  	</form>
			<thead>
				<tr>
					<th>Delete</th>
					<th>Description</th>
					<th>Due Date</th>
					<th>Complete</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="myTasks" items="${tasks}">
					<tr>
					    <td><button type="submit" onClick="javascript:location.href = '/delete-task?id=${myTasks.id}';" >Delete</button></td>
						<td>${myTasks.description}</td>
						<td>${myTasks.duedate}</td>
						<td>${myTasks.complete}</td>
						<td><button type="submit" onClick="javascript:location.href = '/changeTasktoComplete?id=${myTasks.id}';" >Complete/Incomplete</button></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
		<br><br><a href="/sortby-duedate">SortBy DueDate</a>
	  <br><br><a href="/add-task">Add a Task</a><br><br>
	  	<form action="/logout">
		<button type="submit">Logout</button>
		</form>
	  
	</div>
</body>
</html>