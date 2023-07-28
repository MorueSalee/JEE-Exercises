<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fr.allfont.net/allfont.css?fonts=zapfchancery-cyrillic-italic"
	rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<title>Le livre dont vous êtes le Héros</title>
<style>
.justified-text {
	text-align: justify;
	width: 400px;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	/* Ensure the container fills the whole viewport */
	margin: 0;
	align-items: center;
	height: 100vh; /* Remove default body margin */
	/* Set the background image path using the url() function */
	background-image:
		url('https://img.freepik.com/photos-gratuite/fond-plancher-bois_53876-88628.jpg?w=900&t=st=1689934146~exp=1689934746~hmac=1d831a7ad744cb13ea99ef1e6c89b1818fa368f15ef96be4441a1bee87eb72c1');
	/* Set other background properties as needed */ background-repeat :
	no-repeat; /* Optional: control image repetition */ background-size :
	cover;
	font-family: 'ZapfChancery Cyrillic Italic', arial;
	background-repeat: no-repeat; /* Optional: control image repetition */
	background-size: cover;
}

.centered-div {
	/* Add your div's styling here */
	width: 300px;
	height: 400px;
	text-align: center; /* Optional: center text inside the div */
	padding: 20px; /* Optional: add padding for content */
}
</style>
</head>
<body>
	<div class="centered-div">
		<h1>Votre Histoire</h1>
		<form action="BookServlet" method="POST">
			<div class="justified-text">
				<p>${page.storySection }</p>
			</div>

			<h2>Votre inventaire:</h2>
			<div>${model.message}</div>
			<c:forEach items="${model.inventory}" var="object">
				<p>${object}</p>
			</c:forEach>

			<c:forEach items="${page.pageList}" var="pageChoice">
				<input type="submit" name="pageNumber"
					value="${pageChoice.pageNumber}" />
			</c:forEach>
		</form>
	</div>
</body>
</html>