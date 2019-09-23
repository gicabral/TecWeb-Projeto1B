<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  <%@include file="style.css" %>  
</style>

</head>
<body>
	<div class = "login-box">
		<img src="add.png" class="avatar">
			<h1>Sign Up Here</h1>
				<form action="./Register" method="post">
					<p>Username</p>
					<input type="text" name="usuario" placeholder="Enter Username"> 
					<p>Password</p>
					<input type="password" name="senha" placeholder="Enter Password"> 
					<p>Confirm Password</p>
					<input type="password" name="confirmarsenha" placeholder="Confirm Password"> 
					<input type="submit" name="cadastro" value="sign up">
					<a href='./'>Back</a>
				</form>
		
			</div>

</body>
</html>