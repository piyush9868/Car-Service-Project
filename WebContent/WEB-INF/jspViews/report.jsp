<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Report</h1>
<table border="1px">
	
	<tr>
		<th>Car Type</th>
		<th>Car Number</th>
		<th>Username</th>
		<th>Total Repair Cost</th>
	</tr>
	<c:forEach items="${beansList}" var = "customer">
		<tr>
			<td>${customer.carType}</td>
			<td>${customer.carNumber}</td>
			<td>${customer.username}</td>
			<td>${customer.totalRepairCost}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>