<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NPC List</title>
</head>
<body>
	<form action="navigationServlet" method="post">
		<table>
			<tr>
				<td></td>
				<td><strong>Name</strong></td>
				<td><strong>Race</strong></td>
				<td><strong>Age</strong></td>
			</tr>
			<c:forEach items="${requestScope.allNpcs}" var="currentNpc">
				<tr>
					<td><input type="radio" name="id" value="${currentNpc.id}"></td>
					<td>${currentNpc.name}</td>
					<td>${currentNpc.race}</td>
					<td>${currentNpc.age}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThis">
		<input type="submit" value="delete" name="doThis">
		<input type="submit" value="add" name="doThis">
	</form>
	<button onclick="window.location.href='index.html'">Home</button>
</body>
</html>