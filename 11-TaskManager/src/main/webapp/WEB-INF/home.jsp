<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Manager</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="container mx-auto">
    <h1 class="text-4xl font-bold mt-4">Task Manager 2K23 Genius Edition</h1>
    <p class="mt-2">${model.message}</p>
    <form action="TaskServlet" method="post" class="mt-4">
        <div class="mb-4">
            <label class="block">Name :</label>
            <input type="text" name="label" value="${model.current.label}" class="border rounded py-1 px-2 w-64" />
        </div>
        <div class="mb-4">
            <label class="block">Starting date :</label>
            <input type="date" name="dtStart" value="${model.current.dtStart}" class="border rounded py-1 px-2 w-64" />
        </div>
        <div class="mb-4">
            <label class="block">Ending date :</label>
            <input type="date" name="dtEnd" value="${model.current.dtEnd}" class="border rounded py-1 px-2 w-64" />
        </div>
        <div class="mb-4">
            <label class="block">Starting time :</label>
            <input type="time" name="hStart" value="${model.current.hStart}" class="border rounded py-1 px-2 w-64" />
        </div>
        <div class="mb-4">
            <label class="block">Ending time :</label>
            <input type="time" name="hEnd" value="${model.current.hEnd}" class="border rounded py-1 px-2 w-64" />
        </div>
        <div class="mb-4">
            <label class="block">Priority :</label>
            <select name="priority">
			  <option value="1">1</option>
			  <option value="2">2</option>
			  <option value="3">3</option>
			</select>
        </div>
        <div class="mb-4">
            <label class="block">Status :</label>
            <select name="isDone">
			  <option value="true">True</option>
			  <option value="false">False</option>
			</select>
        </div>
        <input type="submit" name="BT1" value="Add" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 cursor-pointer" />
    </form>
    <div class="mt-8">
        <h3 class="text-2xl font-bold">My task list :</h3>
        <div class="mt-2">
            <c:forEach items="${model.taskList}" var="task">
                <div class="border rounded p-2 mb-2">
                	
                    <p><span class="font-bold">Name :</span> ${task.label}</p>
                    <p><span class="font-bold">Starting date :</span>
                    <fmt:parseDate value="${task.dtStart}" pattern="yyyy-MM-dd" var="parsedDate" type="Date"/>
					<fmt:formatDate value="${parsedDate}" dateStyle="full"/>
                    <p><span class="font-bold">Ending date :</span>
                     <fmt:parseDate value="${task.dtEnd}" pattern="yyyy-MM-dd" var="parsedDate" type="Date"/>
					<fmt:formatDate value="${parsedDate}" dateStyle="full"/></p>
                    <p><span class="font-bold">Starting hour :</span> ${task.hStart}</p>
                    <p><span class="font-bold">Ending hour :</span> ${task.hEnd}</p>
                    <p><span class="font-bold">Priority :</span> ${task.priority}</p>
                    <p><span class="font-bold">Status :</span> ${task.isDone}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>