<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<div class="header"></div>
<div class = "login-box">
	<h1>Add new question</h1>  
		<form action="./adduser" method="post">  
		<b>Name:</b>
		<input type="text" name="name" placeholder="Enter your name">
		<b>Question:</b>  
		<input type="text" name="question" placeholder="Enter question"> 
		<b>Importance:</b> 
		<select name="importance" style="width:155px">  
		<option>Urgent</option>  
		<option>Not that urgent</option>  
		</select>  
		<br>
		<br>
		<input type="submit" value="Add Question">
		<br>
		<a href="./PaginaInicial">Back</a> 
		<a href="./viewusers">View All Questions</a><br/>  
		</form>  
</div>
</html>