<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Example</title>
</head>
<body>
	<h3>Welcome, View User Details</h3>

	<form:form modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="contactNumber">Contact Number</form:label></td>
				<td><form:input path="contactNumber" readonly="true"/></td>
			</tr>
			
			<tr>
				<td><form:input path="contactNumber" readonly="true"/></td>
			</tr>	
			
		</table>
	</form:form>

</body>

</html>