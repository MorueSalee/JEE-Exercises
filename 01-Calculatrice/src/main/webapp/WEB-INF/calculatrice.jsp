<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ma Calculatrice</title>
</head>
<body>

<form action="CalculatriceServlet" method="post">
	<input type = "number" name="a" value="${a}"/>
	<input type = "number" name="b" value="${b}"/>
	<input type = "submit" value="+"/>
</form>

<h1>Le résultat ${resultat}</h1>
</body>
</html>