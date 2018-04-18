<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">

First Name: <form:input path="firstName" />

		<br>
		<br>

Last Name: <form:input path="lastName" />

		<br>
		<br>
		
		<form:select path="country">

<form:options items="${student.countryOptions}"/>

</form:select>

			<br>			<br>
			Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			C# <form:radiobutton path="favoriteLanguage" value="C#"/>
			Python <form:radiobutton path="favoriteLanguage" value="Python"/>
			JS <form:radiobutton path="favoriteLanguage" value="JS"/>
			<br>			<br>
			Operating System: 
			Windows<form:checkbox path="OS" value = "Windows"/>
			MAC<form:checkbox path="OS" value = "MAC"/>
			Linux<form:checkbox path="OS" value = "Linux"/>
			<br>			<br>
			<input type="Submit" value="Submit" />
	</form:form>
</body>

</html>