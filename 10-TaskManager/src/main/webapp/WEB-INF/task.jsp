<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fmt:setBundle basename="fr.formation.task.bundles.message" var="r"/>
	
	<h4>${model.message}</h4>
	<div>
		<fmt:parseDate value="${model.current.start}" pattern="yyyy-MM-dd'T'HH:mm" var="st" type="both" />
		<fmt:parseDate value="${model.current.end}" pattern="yyyy-MM-dd'T'HH:mm" var="en" type="both" />
		<form action="TaskServlet" method="post">
			<label><fmt:message key="lb_label" bundle="${r}"/></label><input type="text" name="label" value="${model.current.label}"/><br>
			<label><fmt:message key="lb_start" bundle="${r}"/></label><input type="datetime-local" name="start" value="<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm" value="${st}" />"/><br>
			<label><fmt:message key="lb_end" bundle="${r}"/></label><input type="datetime-local" name="end" value="<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm" value="${en}" />"/><br>
			<label><fmt:message key="lb_priority" bundle="${r}"/></label><input type="number" name="priority" value="${model.current.priority}"/><br>
			<input type="submit" name="BT_ADD" value="<fmt:message key="bt_add" bundle="${r}"/>"/><br>
		</form>
		<c:forEach items="${model.lstTasks}" var="task">
				<fmt:parseDate value="${task.start}" pattern="yyyy-MM-dd'T'HH:mm" var="st" type="both" />
				<fmt:parseDate value="${task.end}" pattern="yyyy-MM-dd'T'HH:mm" var="en" type="both" />
				<li>
					<fmt:message key="wd_do" bundle="${r}"/> ${task.label} <fmt:message key="wd_from" bundle="${r}"/> <fmt:formatDate pattern="dd/MM/yyyy(HH:mm)" value="${st}" /> <fmt:message key="wd_to" bundle="${r}"/> <fmt:formatDate pattern="dd/MM/yyyy(HH:mm)" value="${en}" />  (${task.priority})
				</li>
		</c:forEach>

	</div>
</body>
</html>