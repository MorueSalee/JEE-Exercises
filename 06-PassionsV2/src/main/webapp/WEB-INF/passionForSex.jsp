<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Infos Personelles</title>
</head>
<body>

	<h1>Choisissez vos Passions</h1>

	<form action="passionForSexServlet" method="Post">
		<label>Passions: </label>
		<c:if test="${model.current.sex=='femme'}">
			<div><input type="checkbox" name="passion" value="Poney"/><label for="Poney">Poney</label></div>
			<div><input type="checkbox" name="passion" value="Curling"/><label for="Curling">Curling</label></div>
			<div><input type="checkbox" name="passion" value="Jardinage"/><label for="Jardinage">Jardinage</label></div>
		</c:if>
		<c:if test="${model.current.sex=='homme'}">
			<div><input type="checkbox" name="passion" value="eclipse"/><label for="eclipse">Eclipse</label></div>
			<div><input type="checkbox" name="passion" value="Biere"/><label for="Biere">Bière</label></div>
			<div><input type="checkbox" name="passion" value="PMU"/><label for="PMU">PMU</label></div>
		</c:if>

		<input type="submit" value="Envoyer"/>
	</form>

</body>
</html>