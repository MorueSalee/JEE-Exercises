<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Récapichef :</title>
</head>
<body>

<h1>Résumé de vos infos</h1>

<label>Prénom : ${model.current.surname}</label><br>
<label>Nom : ${model.current.name}</label><br>
<label>Sexe : ${model.current.sex}</label><br>
<br>
<label>Vos passions :</label><br>
<c:forEach items="${model.listPassion}" var="passion">
	<label>- ${passion}</label><br>
</c:forEach>

<form action="summaryServlet" method="post">
	<input type="submit" value="Retour Accueil">
</form>
</body>
</html>