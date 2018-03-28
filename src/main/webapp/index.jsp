<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form id="searchSME" modelAttribute="searchSME" action="searchSME.htm" method="post">
<table align="center">
                    <tr>
                        <td>
                            Search SME:
                        </td>
                        <td>
                            <form:input path="searchTopic" name="searchTopic" id="searchTopic" />
                        </td>
                    </tr>
                   
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="login" name="login">Search</form:button>
                            <a href = "EndorseSME.htm"  class="button">EndorseSME</a>
                        </td>
                    </tr>
                    <tr></tr>
                    
                </table>

</form:form>
</body>
</html>