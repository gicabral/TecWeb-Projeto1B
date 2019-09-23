<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Users</title>  
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
  h1{
    margin: 0;
    padding: 0 0 20px;
    text-align: center;
    font-size: 50px;
    color:#000;
    
  }  
  .botao{
  background: #1c8adb;
  color: #fff;
  padding: 14px 25px;
  height:50px;
  width:200px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border-radius:7px;
}

  .btn{
  background: #1c8adb;
  color: #fff;
  padding: 0px 0px;
  height:20px;
  width:100px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border-radius:7px;
  }
  
  .btn:hover, .btn:active{
  cursor: pointer;
  background: #39dc79;
  color:#000;
  }


  .botao:hover, .botao:active {
  cursor: pointer;
  background: #39dc79;
  color:#000;
}
  .botao2{
  background: #1c8adb;
  color: #fff;
  padding: 14px 25px;
  height:50px;
  width:200px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border-radius:7px;
  margin-left:1065px;
}


  .botao2:hover, .botao:active {
  cursor: pointer;
  background: #39dc79;
  color:#000;
}
</style>
</head>
<body>  
  
<%@page import="mvc.model.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>List of Questions</h1>  
  
<%  
List<User> list=DAO.getAllRecords();  
request.setAttribute("list",list);  
%>  

<div class="w3-container">

	<table border="1" class="w3-table-all w3-card-4">  
	<tr class = "w3-blue"><th>Id</th><th>Name</th><th>Question</th><th>Importance</th>  
	<th>Answer</th><th>Add answer</th><th>Edit</th><th>Delete</th></tr>  
	<c:forEach items="${list}" var="u">  
	<tr><td>${u.getId()}</td><td>${u.getName()}</td><td>${u.getQuestion()}</td>  
	<td>${u.getImportance()}</td><td>${u.getAnswer()}</td>
	<td><a class = "btn" href="answer?id=${u.getId()}">Answer</a></td>  
	<td><a class = "btn" href="./editform?id=${u.getId()}">Edit</a></td>  
	<td><a class = "btn" href="./deleteuser?id=${u.getId()}">Delete</a></td>
	
	</tr>  
	</c:forEach>  
	</table>  
	<br/><a class = "botao" href="./adduserform">Add New Question</a> 
	 
	<a class = "botao2" href=".//">Log out</a>  
	
	
	
</div>
  
</body>  
</html>  