<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
System.out.println("")
<table border="2">
<tr>
	<td>Employee Id</td>
	<td>Employee Name</td>
	<td>Employee ID</td>
	<td>Employee skills</td>
</tr>

	<c:forEach var="sme" items="${smeList}">
	<tr>
		<td>${sme.firstName}</td>
		<td>${sme.lastName}</td>
		<td>${sme.ID}</td>
		<td>${sme.skills}</td>
	</tr>
	</c:forEach>
	
	
</table>
	
</body>
</html>