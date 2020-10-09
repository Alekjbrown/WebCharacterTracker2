<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Stat Block</title>
</head>
<body>
	<form action="createNewNPCServlet" method="post">
		Name: <input type="text" name="npcName"><br>
		Race: <input type="text" name="npcRace"><br>
		Age: <input type="number" name="npcAge"><br>
		Strength: <input type="number" name="npcStrength"><br>
		Dexterity: <input type="number" name="npcDexterity"><br>
		Constitution: <input type="number" name="npcConstitution"><br>
		Intelligence: <input type="number" name="npcIntelligence"><br>
		Wisdom: <input type="number" name="npcWisdom"><br>
		Charisma: <input type="number" name="npcCharisma"><br>
		<input type="submit" value="Create NPC and Stat Block">
	</form>
	<a href="index.html">Go Home</a>
</body>
</html>