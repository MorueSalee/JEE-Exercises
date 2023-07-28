<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Right Management - Signin</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
	<form action="Servlet" method="post">
		<label>First Name : </label>
		<input type="text" name="firstName" value="${model.current.firstName}">
		<label>Name : </label>
		<input type="text" name="name" value="${model.current.name}">
		<label>Email : </label>
		<input type="email" name="login" value="${model.current.login}">
		<label>Password : </label>
		<input type="password" name="password" value="${model.current.password}">
		<input type="submit" name="signinButton" value="Create account">
		<input type="submit" name="goToHome" value="Go Back home">
	</form>
	<div>
		<label>${model.message}</label>
	</div>
</body>
</html>