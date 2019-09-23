<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
  <%@include file="style.css" %> 
</style>

</head>

<body>
	<div class = "login-box">
	<img src="avatar.png" class="avatar">
		<h1>Login Here</h1>
			<form action="./paginaInicial" method="post">
				<b>Username</b>
				<input type="text" name="usuario" placeholder="Enter Username"> 
				<b>Password</b>
				<input type="password" name="senha" placeholder="Enter Password"> 
				<input type="submit" name="login" value="login">
				<a href='./register'>Sign Up</a>
			</form>
	
		</div>
	
</body>

</html>