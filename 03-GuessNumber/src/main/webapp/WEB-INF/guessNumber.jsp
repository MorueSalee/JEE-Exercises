<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guess Number</title>
</head>
<body>
<h1>Guess Number !</h1>
<p>Give a guess :</p>
<form action="GuessNumberServlet" method="post">
	<input type = "number" name="number" value="${number}"/>
	<input type = "submit" value = "Try !"/>
</form>
<p>${message}</p>
</body>
</html>