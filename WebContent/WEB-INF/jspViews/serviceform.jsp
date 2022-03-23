<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<!--<h2>${servicebean.carType}</h2>  -->
	${servicebean.carType }
		<h1>Register for Car Service</h1>
		<br>
		<form:form action="submitform.html" method="post"
			modelAttribute="servicebean">
			<table>
				<tr>
					<td>Car Number:</td>
					<td><form:input name="carNumber" path="carNumber"></form:input></td>
					<td><form:errors 
					path="carNumber"></form:errors>
				</tr>
				<tr>
					<td>Parts Name:</td>
					<td><form:select path="partId">

							<form:options items="${partDetails}" />
						</form:select></td>
					<td><form:errors path="partId"></form:errors></td>
				</tr>

				<tr>
					<td>Username:</td>
					<td><form:input path="username" /></td>
					<td><form:errors path="username" /></td>
					<td><form:hidden path = "carType" value = "${carType}"/></td>
				</tr>
				<tr>
					<td><a href="register.html">HOME</a>
					<td><input type="submit" value="Book Service"></td>
				</tr>
			</table>
		</form:form>
	




</body>
</html>