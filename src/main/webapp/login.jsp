<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login page</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
	<header>
		<h1>Admin Login</h1>
	</header>
	<main>
		<form name="login" class="form-class" action="login" method="post">
			<div class="form-div">
				<label>Login:</label> <input class="field-class" name="username"
					type="text" placeholder="User Name" autofocus> <label>Password:</label>
				<input id="pass" class="field-class" name="password" type="password"
					placeholder="password"> <input type="submit" name="submit"
					value="submit">
			</div>

		</form>
	</main>

</body>
</html>