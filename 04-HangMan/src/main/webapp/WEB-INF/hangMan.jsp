<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Hang Man</title>
<style>
        .preserve-spaces {
            white-space: pre;
        }
    </style>
</head>
<body>
<h1>The Hang Man</h1>
<p>Give a guess :</p>
<form action="HangManServlet" method="post">
	<input type = "text" name="letter" value="${letter}"/>
	<input type = "submit" value = "?"/>
</form>
<p>${wordToGuess}</p>
<p>${message}</p>
<p class="preserve-spaces">${hangMan}</p>
</body>
</html>