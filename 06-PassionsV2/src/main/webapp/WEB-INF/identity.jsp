<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Infos Personelles</title>
</head>
<body>

	<h1>Saisir vos Infos</h1>

	<form action="IdentityServlet" method="post">
		<label>Nom: </label>
		<input type="text" name="name" value="${name}"/> <br><br>
		
		<label>Prenom: </label>
		<input type="text" name="surname" value="${surname}"/> <br><br>
		
		<label>Sexe: </label>
		
		
		
		<select name="sex" id="sex">
			<option value="homme">Homme</option>
			<option value="femme">Femme</option>
			<option value="autre">Autre</option>
		</select><br><br>
		
		<input type="submit" value="Envoyer"/>
	</form>

</body>
</html>