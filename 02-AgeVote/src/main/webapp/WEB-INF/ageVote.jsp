<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Age Vote</title>
</head>
<body>
<h1>Vérifiez si vous pouvez voter !</h1>
<form action="AgeVoteServlet" method="post">
	<input type = "text" name="prenom" value="${prenom}"/>
	<br>
	<input type = "text" name="nom" value="${nom}"/>
		<br>
	
	<input type = "number" name="age" value="${age}"/>
		<br>
	
	<select name="nationalite">
		<option value="français">Français</option>
		<option value="anglais">Anglais</option>
		<option value="allemand">Allemand</option>
		<option value="turque">Turque</option>
		<option value="portugais">Portugais</option>
	</select>
	
	<input type = "submit" value="Envoyer"/>
</form>

<h2>Resultat :</h2>
<p>${resultat}</p>
</body>
</html>