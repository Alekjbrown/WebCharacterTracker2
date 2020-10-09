<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit NPC</title>
</head>
<body>
	<form action="editNPCServlet" method="post">
		<div>
			<label for="name">Name:&nbsp;</label>
			<input type="text" name="name" value="${npcToEdit.name}" required>
		</div>
		<div>
			<label for="race">Race:&nbsp;</label>
			<input type="text" name="race" value="${npcToEdit.race}">
		</div>
		<div>
			<label for="age">Age:&nbsp;</label>
			<input type="number" name="age" value="${npcToEdit.age}">
		</div>
		<div>
			<input type="hidden" name="id" value="${npcToEdit.id}">
			<input type="submit" value="Save Edited NPC">
		</div>
	</form>
</body>
</html>