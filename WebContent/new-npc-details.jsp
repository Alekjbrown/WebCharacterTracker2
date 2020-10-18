<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New NPC Detail</title>
</head>
<body>
	<form action="createNewNPCServlet" method="post">
		Name: <input type="text" name="npcName"><br> Race: <input
			type="text" name="npcRace"><br> Age: <input
			type="number" name="npcAge"><br> <Select
			name="statblockToAdd">
			<c:forEach items="${requestScope.allStatblocks}" var="currentBlock">
				<option value="${currentBlock.id}">
					<table>
						<tr>
							<td>Strength:</td>
							<td>${currentBlock.strength}</td>

							<td>Dexterity:</td>
							<td>${currentBlock.dexterity}</td>

							<td>Constitution:</td>
							<td>${currentBlock.constitution}</td>

							<td>Intelligence:</td>
							<td>${currentBlock.intelligence}</td>

							<td>Wisdom:</td>
							<td>${currentBlock.wisdom}</td>

							<td>Charisma:</td>
							<td>${currentBlock.charisma}</td>

						</tr>

					</table>
				</option>
			</c:forEach>
		</Select> <input type="submit" value="Create NPC and Add Statblock">
	</form>
	<a href="index.html">Go Home</a>
</body>
</html>