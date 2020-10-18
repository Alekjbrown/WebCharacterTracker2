<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NPC Details</title>
</head>
<body>
	<form method="post" action="detailsNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allNpcs}" var="currentNpc">
				<tr>
					<td><input type="radio" name="id" value="${currentNpc.id}">
					<h2>${currentNpc.npc.name}</h2>
					</td>
				</tr>
				<tr>
					<td colspan="3">Race: ${currentNpc.npc.race}</td>
				</tr>
				<tr>
					<td colspan="3">Age: ${currentNpc.npc.age}</td>
				</tr>
				<table>
					<tr>
						<td>STR</td>
						<td>DEX</td>
						<td>CON</td>
						<td>INT</td>
						<td>WIS</td>
						<td>CHA</td>
					</tr>
					<tr>
						<td>${currentNpc.statblock.strength}</td>
						<td>${currentNpc.statblock.dexterity}</td>
						<td>${currentNpc.statblock.constitution}</td>
						<td>${currentNpc.statblock.intelligence}</td>
						<td>${currentNpc.statblock.wisdom}</td>
						<td>${currentNpc.statblock.charisma}</td>
					</tr>
				</table>
				<h1>--------------------------</h1>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThis">
		<input type="submit" value="delete" name="doThis">
		<input type="submit" value="add" name="doThis">
	</form>
	<button onclick="window.location.href='index.html'">Home</button>
</body>
</html>