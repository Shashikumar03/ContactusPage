<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="index.css">
<title>First page</title>
</head>
<body>
	<div class="container">
		<div class="contact">
			<form action="contactus" method="get">
				<input type="submit" name="submit" value="contact Us">
			</form>
		</div>
		<div class="admin" method="get">
			<form action="login">
				<input type="submit" name="login" value="Admin login">
			</form>
		</div>

	</div>
</body>
</html>