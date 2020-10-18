<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Statblock</title>
</head>
<body>
	<h1>Add New Statblock</h1>
	<form action="addStatblockServlet" method="post">
		Strength: <input type="number" name="strength"><br>
		Dexterity: <input type="number" name="dexterity"><br>
		Constitution: <input type="number" name="constitution"><br>
		Intelligence: <input type="number" name="intelligence"><br>
		Wisdom: <input type="number" name="wisdom"><br>
		Charisma: <input type="number" name="charisma"><br>
		<input type="submit" value="Save New">
	</form>
	<br>
	<button onclick="window.location.href='index.html'">Home</button>
</body>
</html>