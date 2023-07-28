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
			<h4 class="text-red-500 mb-4">${model.message}</h4>

			<form action="BiereServlet" method="post">
				<div class="flex mb-4">
					<div class="w-1/2">Nom :</div>
					<div class="w-3/4 border border-gray-500 rounded">
						<input type="text" name="nom" value="${model.current.nom}"
							class="w-full border-gray-300 rounded focus:outline-none focus:ring-blue-500 focus:border-blue-500">
					</div>
				</div>
				<div class="flex mb-4">
					<div class="w-1/2">Couleur :</div>
					<div class="w-3/4 border border-gray-500 rounded">
						<input type="text" name="couleur" value="${model.current.couleur}"
							class="w-full border-gray-300 rounded focus:outline-none focus:ring-blue-500 focus:border-blue-500">
					</div>
				</div>
				<div class="flex mb-4">
					<div class="w-1/2">Brasserie :</div>
					<div class="w-3/4 border border-gray-500 rounded">
						<input type="text" name="brasserie"
							value="${model.current.brasserie}"
							class="w-full border-gray-300 rounded focus:outline-none focus:ring-blue-500 focus:border-blue-500">
					</div>
				</div>
				<div class="flex mb-4">
					<div class="w-1/2">Degrès d'alcool :</div>
					<div class="w-3/4 border border-gray-500 rounded">
						<input type="text" name="alcool" value="${model.current.alcool}"
							class="w-full border-gray-300 rounded focus:outline-none focus:ring-blue-500 focus:border-blue-500">
					</div>
				</div>
				<div class="flex mb-4">
					<div class="w-1/2">Commentaire :</div>
					<div class="w-3/4 border border-gray-500 rounded">
						<input type="text" name="commentaire"
							value="${model.current.commentaire}"
							class="w-full border-gray-300 rounded focus:outline-none focus:ring-blue-500 focus:border-blue-500">
					</div>
				</div>
				<div class="flex mb-4">
					<div class="w-1/2">Note :</div>
					<div class="w-3/4 rounded">
						<select name="note" id="cars"
							class="w-full border-gray-300 rounded focus:outline-none focus:ring-blue-500 focus:border-blue-500">
							<option value="5">5</option>
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
							<option value="0">0</option>
						</select>
					</div>
				</div>
				<div class="flex mb-4">
					<div class="w-1/2">Prix :</div>
					<div class="w-3/4 border border-gray-500 rounded">
						<input type="text" name="prix" value="${model.current.prix}"
							class="w-full border-gray-300 rounded focus:outline-none focus:ring-blue-500 focus:border-blue-500">
					</div>
				</div>
				<div class="flex justify-end">
					<input type="submit" name="addList" value="Valider"
						class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 cursor-pointer">
				</div>
			</form>

			<h4 class="mt-8">
				<form action="BiereServlet" method="post">
					<input type="submit" name="getCart" value="Voir mon panier"
						class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 cursor-pointer">
					<hr class="my-4">
					<c:forEach items="${model.lstBieres}" var="item">
						<p class="mb-2">La ${item.nom} est une bière ${item.couleur} à
							${item.alcool}°, brassée chez ${item.brasserie}.</p>
						<p class="mb-2">Note : ${item.note}</p>
						<p class="mb-2">Commentaires : ${item.commentaire}</p>
						<p class="mb-2">Prix : ${item.prix}</p>
						<div>
							<label>Ajouter au panier :</label> <input type="checkbox"
								name="panier" value="${item.id}">
						</div>
						<hr class="my-4">
					</c:forEach>
					<c:if test="${model.lstBieres[0] != null}">
						<input type="submit" name="addCart" value="Envoyer au panier"
							class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 cursor-pointer">
					</c:if>

				</form>
			</h4>
		</div>
	</div>
</body>
</html>