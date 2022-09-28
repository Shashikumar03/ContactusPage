<%@page import="com.model.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>dashboard</title>
<style>
table, tr, th, td {
	border: 2px solid black;
}
</style>
</head>
<body>

	<div class="container">
		<table id="table">
			<thead>
				<tr>
					<th>name</th>
					<th>email</th>
					<th>message</th>
					<th>status</th>

				</tr>
			</thead>
			<%
			ArrayList<Request> dataBaseInfo = (ArrayList) request.getAttribute("dataBaseInfo");

			for (Request database : dataBaseInfo) {
				if (database.getStatus().equals("active")) {
			%>

			<tr>
				<td><%=database.getName()%></td>
				<td><%=database.getEmail()%></td>
				<td><%=database.getMessage()%></td>

				<form action="dashboard" method="post">
					<td><input type="submit" value="<%=database.getStatus()%>"
						name="button"> <input type="hidden"
						value="<%=database.getId()%>" name="dataButton"></td>
				</form>
			</tr>
			<%
			}
			}
			%>

		</table>
	</div>

	<hr>
	<div class="container">
		<table id="table">
			<thead>
				<th>name</th>
				<th>email</th>
				<th>message</th>
				<th>status</th>


			</thead>
			<%
			for (Request database : dataBaseInfo) {
				if (database.getStatus().equals("archive")) {
			%>

			<tr>

				<td><%=database.getName()%></td>
				<td><%=database.getEmail()%></td>
				<td><%=database.getMessage()%></td>

				<form action="dashboard" method="post">
					<td><input type="submit" value="<%=database.getStatus()%>"
						name="button"> <input type="hidden"
						value="<%=database.getId()%>" name="dataButton"></td>
				</form>

			</tr>
			<%
			}
			}
			%>

		</table>
	</div>
</body>
</html>