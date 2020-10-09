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
	<form method="post" action="DetailsNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allNpcs}" var="currentNpc">
				<tr>
					<td><input type="radio" name="id" value="${currentNpc.id}"></td>
					<td><h2>${currentNpc.npc.name}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Race: ${currentNpc.npc.race}</td>
				</tr>
				<tr>
					<td colspan="3">Age: ${currentNpc.npc.age}</td>
				</tr>
				<tr>
					<td colspan="3">Strength: ${currentNpc.statblock.strength}</td>
				</tr>
				<tr>
					<td colspan="3">Dexterity: ${currentNpc.statblock.dexterity}</td>
				</tr>
				<tr>
					<td colspan="3">Constitution: ${currentNpc.statblock.constitution}</td>
				</tr>
				<tr>
					<td colspan="3">Intelligence: ${currentNpc.statblock.intelligence}</td>
				</tr>
				<tr>
					<td colspan="3">Wisdom: ${currentNpc.statblock.wisdom}</td>
				</tr>
				<tr>
					<td colspan="3">Charisma: ${currentNpc.statblock.charisma }</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThis">
		<input type="submit" value="delete" name="doThis">
		<input type="submit" value="add" name="doThis">
	</form>
	<a href="addNPCDetailsServlet">Create a new NPC</a>
</body>
</html>