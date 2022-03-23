<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dummy Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h1>Register for Car Service</h1>
		<form action="submitCarType.html" method="get">
			<h3>Select Car Type:</h3>
			<label>Maruti</label> <input type="radio" value="Maruti" name="Cartype"> 
			<label>Hyundai</label><input type="radio" value="Hyundai" name="Cartype"><br><br>
			<input type = "submit" value = "Submit Query">
		</form>
	</center>
</body>
</html>