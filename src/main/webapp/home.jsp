<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelpSME - find SME</title>
<style>
body{
no-repeat center center fixed;
        -webkit-background-size: cover;
		-moz-background-size: cover;
		-o-background-size: cover;
		background-size: cover;
		}
</style>



<style>
.button{
background-color: #e7e7e7;
color: black;
border: none;
      padding: 10px 20px;
	  text-align: center-left;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 14px;
	  margin: 6px 4px;
	  cursor: pointer;
	  button: hover{
	  background-color: #3e8e41;
	  text-decoration:underline;
	}
}
</style>
        
	  
</head>
<body>

<div style= " display:table; margin:0 auto; top:50%; transform: translateY(50%);">

<h1 align="center">HelpSME</h1>

<center>

<form:form id="searchSME" modelAttribute="searchSME" action="searchSME.htm" method="post">

<form:input path="searchTopic" name="searchTopic" id="searchTopic" style="width:550px; height:20px;" /><br/>
TopSearches: <b><c:out value="${topSearch}" /> </b><br/>
 <form:button id="login" name="login" class="button">SearchSME</form:button><a href="EndorseSME.htm" class="button">EndorseSME </a>
 
 
</form:form>	


<center>
</body>




	
</html>