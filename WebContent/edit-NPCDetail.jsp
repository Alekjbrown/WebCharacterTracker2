<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Detail</title>
</head>
<body>
	<form action="editNPCDetailServlet" method="post">
		<input type="hidden" name="id" value="${NPCToEdit.id}">
		Name: <input type="text" name="name" value="${NPCToEdit.npc.name}"><br> 
		Race: <input type="text" name="race" value="${NPCToEdit.npc.race}"><br>
		Age: <input	type="number" name="age" value="${NPCToEdit.npc.age }"><br> 
		<Select	name="statblockToAdd">
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
		</Select><br> 
		<input type="submit" value="Save NPC and Add Statblock">
	</form>
</body>
</html>