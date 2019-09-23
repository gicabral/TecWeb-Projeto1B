<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
<style type="text/css">
  <%@include file="styleform.css" %>
</style>
</head>  
<body>  
<%@page import="mvc.model.*"%>  
  
<%  
String id=request.getParameter("id");  
User u=DAO.getRecordById(Integer.parseInt(id));  
%>  
  

<div class = "login-box">
	<h1>Edit Question</h1>  
		<form action="./edituser" method="post">  
		<input type="hidden" name="id" value="<%=u.getId() %>"/>  
		<b>Name:</b>
		<input type="text" name="name" placeholder="Enter your name"  value="<%= u.getName()%>" required/>
		<b>Question:</b>  
		<input type="text" name="question" placeholder="Enter question" value="<%= u.getQuestion()%>" required/> 
		<b>Importance:</b> 
		<select name="importance" style="width:155px" required>  
		<option>Urgent</option>  
		<option>Not that urgent</option>  
		</select>  
		<br>
		<br>
		<input type="submit" value="Edit Question">
		<br> 
		<a href="./viewusers">Back</a><br/>  
		</form>  
</div>