<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>${model.message}</p>
<form action="ContactServlet" method="post">
	nom : <input type="text" name="nom" value="${model.current.nom}"/><br>
	prenom : <input type="text" name="prenom"  value="${model.current.prenom}"/><br>
	tel : <input type="text" name="tel"  value="${model.current.tel}"/><br>
	<input type="submit" value="ajouter"/>
</form>
<h4>
${model.lstContacts}
</h4>
</body>
</html>