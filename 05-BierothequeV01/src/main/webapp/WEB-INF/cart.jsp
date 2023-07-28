<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bièrothèque Edition 2023 Premium</title>
<script src="https://cdn.tailwindcss.com"></script>
<link href="https://cdn.tailwindcss.com/2.2.19/tailwind.min.css"
	rel="stylesheet">

</head>
<body class="bg-cover bg-no-repeat bg-center"
	style="background-image: url('https://br.web.img2.acsta.net/pictures/17/07/07/14/35/150302.jpg');">
	<div class="flex justify-center items-center min-h-screen">
		<div class="max-w-md p-8 bg-white bg-opacity-50 rounded shadow">
			<h1 class="text-4xl font-bold">Bièrothèque Edition 2023 Premium</h1>
			<br>
			<form action="BiereServlet" method="post">
				<input type="submit" name="getHome" value="Retour Accueil"
					class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 cursor-pointer">
			</form>
			<br>
			<h4 class="text-red-500 mb-4">${model.message}</h4>
			<h2 class="text-4xl">Votre Panier :</h2>
			<h4 class="mt-8">

				<form action="BiereServlet" method="post">
					<hr class="my-4">
					<c:forEach items="${modelPanier.lstBieres}" var="item">
						<p class="mb-2">La ${item.nom} est une bière ${item.couleur} à
							${item.alcool}°, brassée chez ${item.brasserie}.</p>
						<p class="mb-2">Note : ${item.note}</p>
						<p class="mb-2">Commentaires : ${item.commentaire}</p>
						<hr class="my-4">
					</c:forEach>


				</form>
			</h4>
		</div>
	</div>
</body>
</html>