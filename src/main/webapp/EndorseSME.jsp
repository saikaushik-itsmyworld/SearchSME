<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
body {font-family: Arial;}
* {box-sizing: border-box}
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}



/* Float signup button and add an equal width */
 .Endorsebtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: #474e5d;
    padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change style for signup button on extra small screens */
@media screen and (max-width: 300px) {
     .Endorsebtn {
       width: 100%;
    }
}
</style>
<body>

<h2>SME Endorsement Form</h2>
	${msg}
	<form:form class="modal-content" action="insertSME.htm" method="post" >
	<div class="container">
		<input type="text" name="firstName"/><br/>
		<input type="text" name="lastName"/><br/>
		<input type="text" name="ID"/><br/>
		<input type="text" name="rating"/><br/>
		<input type="text" name="skills"/><br/>
		<input type="text" name="yourname"/><br/>
		<div class="clearfix">
		<button type="submit" class="Endorsebtn">Endorse</button>
		</div>
		</div>
	</form:form>
  <%-- <form:form class="modal-content" modelAttribute="smePojo" action="insertSME.htm" method="post">
    <div class="container">
      <h1>EndorseSME</h1>
      <p>Please fill in this form to Endorse an SME</p>
      <hr>
      <label><b>SME FirstName</b></label>
	 <form:input path="firstName" placeholder="Enter FirstName" name="firstName" id="firstname" />
      <label><b>SME LastName</b></label>
      <form:input path="lastName" name="lastName" id="lastname" />

      <label><b>SME NBKID</b></label>
      <form:input path="ID" placeholder="Enter id" name="ID" id="id" />
      
      <label><b>Endorsing on Topic</b>
        <form:input path="skills" placeholder="Enter skill" name="skill" id="skill" />

       <label><b>your rating</b>
        <form:input path="rating" placeholder="enter rating" name="rating" id="rating" />
      
      <label><b>yourname</b>
        <form:input path="yourname" placeholder="enter yourname" name="yourname" id="yourname" />
      <div class="clearfix">
      
        <button type="submit" class="Endorsebtn">Endorse</button>
      </div>
    </div>
  </form:form>
 --%>

<script>
// Get the modal
var modal = document.getElementById('id01');
</script>
</body>
</html>