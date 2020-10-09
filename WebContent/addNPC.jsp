<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New</title>
</head>
<body>
	<form action="addNPCServlet" method="post">
		<div>
			<label for="name">Name:&nbsp;</label>
			<input type="text" name="name" required>
		</div>
		<div>
			<label for="race">Race:&nbsp;</label>
			<input type="text" name="race">
		</div>
		<div>
			<label for="age">Age:&nbsp;</label>
			<input type="number" name="age">
		</div>
		<div>
			<input type="submit" value="Save new NPC">
		</div>
	</form>
	<br>
	<form action="viewAllNPCServlet">
		<input type="submit" value="View All NPCs">
	</form>
</body>
</html>