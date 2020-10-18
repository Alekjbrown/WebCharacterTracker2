<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit StatBlock</title>
</head>
<body>
	<h1> Edit StatBlock </h1>
	<form action="editStatBlockServlet" method="post">
		<input type="hidden" name="id" value="${statToEdit.id}">
		Strength: <input type="number" name="strength" value="${statToEdit.strength}"><br>
		Dexterity: <input type="number" name="dexterity" value="${statToEdit.dexterity}"><br>
		Constitution: <input type="number" name="constitution" value="${statToEdit.constitution}"><br>
		Intelligence: <input type="number" name="intelligence" value="${statToEdit.intelligence}"><br>
		Wisdom: <input type="number" name="wisdom" value="${statToEdit.wisdom}"><br>
		Charisma: <input type="number" name="charisma" value="${statToEdit.charisma}"><br>
		<input type="submit" value="Save">
	</form>
</body>
</html>