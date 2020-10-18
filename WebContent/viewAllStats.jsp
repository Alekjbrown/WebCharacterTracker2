<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Stat Blocks</title>
</head>
<body>
	<form action="statsNavigationServlet" method="post">
		<table>
			<tr>
				<td></td>
				<td>Strength</td>
				<td>Dexterity</td>
				<td>Constitution</td>
				<td>Intelligence</td>
				<td>Wisdom</td>
				<td>Charisma</td>
			</tr>
			<c:forEach items="${requestScope.allStatBlocks}" var="currentStatBlock">
				<tr>
					<td><input type="radio" name="id" value="${currentStatBlock.id}"></td>
					<td>${currentStatBlock.strength}</td>
					<td>${currentStatBlock.dexterity}</td>
					<td>${currentStatBlock.constitution}</td>
					<td>${currentStatBlock.intelligence}</td>
					<td>${currentStatBlock.wisdom}</td>
					<td>${currentStatBlock.charisma}</td>
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