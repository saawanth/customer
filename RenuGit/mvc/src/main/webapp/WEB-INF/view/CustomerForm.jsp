<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Customer Form</title>
<style>
.error{color:red}
</style>
</head>
<body>
<i>Fill out the form. (*) means the field is required! </i>
<form:form action="processForm" modelAttribute="customer">
First Name: <form:input path="firstName"/>
<br><br>
Last Name: <form:input path="lastName"/>
<form:errors path="lastName" cssClass="error"/>
Free Passes: <form:input path="freePasses"/>
<form:errors path="freePasses" cssClass="error"/>
Postal Code: <form:input path="postalCode"/>
<form:errors path="postalCode" cssClass="error"/>
<br><br>
<input type="submit" value="submit">

</form:form>
</body>
</html>