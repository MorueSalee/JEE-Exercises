<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Right Management Editor</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
    <form action="Servlet" method="post">
    	<input type="submit" name="goToLogin" value="Login">
    	<input type="submit" name="goToSignin" value="Signin">
    </form>
    <div>
		<label>${model.message}</label>
	</div>
</body>
</html>