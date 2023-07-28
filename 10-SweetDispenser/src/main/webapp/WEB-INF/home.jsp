<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sweet Dispenser!</title>
    <!-- Include Tailwind CSS stylesheet -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="container mx-auto">
    <h1 class="text-4xl font-bold mt-4">Distributeur de bonbons</h1>
    <p class="mt-2">${model.message}</p>
    <form action="SweetServlet" method="post" class="mt-4">
        <div class="mb-4">
            <label class="block">Nom :</label>
            <input type="text" name="name" value="${model.current.name}" class="border rounded py-1 px-2 w-64" />
        </div>
        <div class="mb-4">
            <label class="block">Description :</label>
            <input type="text" name="description" value="${model.current.description}" class="border rounded py-1 px-2 w-64" />
        </div>
        <div class="mb-4">
            <label class="block">Gout :</label>
            <input type="text" name="taste" value="${model.current.taste}" class="border rounded py-1 px-2 w-64" />
        </div>
        <div class="mb-4">
            <label class="block">Prix :</label>
            <input type="number" name="price" value="${model.current.price}" class="border rounded py-1 px-2 w-64" />
        </div>
        <div class="mb-4">
            <label class="block">Quantité :</label>
            <input type="number" name="quantity" value="${model.current.quantity}" class="border rounded py-1 px-2 w-64" />
        </div>
        <input type="submit" name="BT1" value="Ajouter" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 cursor-pointer" />
        <input type="submit" name="BT2" value="Mettre à jour" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 cursor-pointer" />
    </form>
    <div class="mt-8">
        <h3 class="text-2xl font-bold">Ma liste de bonbons :</h3>
        <div class="mt-2">
            <c:forEach items="${model.sweetList}" var="sweet">
                <div class="border rounded p-2 mb-2">
                    <p><span class="font-bold">Nom :</span> ${sweet.name}</p>
                    <p><span class="font-bold">Description :</span> ${sweet.description}</p>
                    <p><span class="font-bold">Gout :</span> ${sweet.taste}</p>
                    <p><span class="font-bold">Prix :</span> ${sweet.price}</p>
                    <p><span class="font-bold">Quantité :</span> ${sweet.quantity}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
