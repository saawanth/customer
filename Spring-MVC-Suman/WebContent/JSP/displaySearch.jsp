<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color='red' size='5'>Movies with search term found</font>
<br>
<c:forEach items="${movies}" var="movie">
<font color='blue' size='5'>${movie.moviename }</font>

<font color='blue' size='5'>${movie.genre }</font>
<br></c:forEach>

<a href="index.html">Click here to go to index</a>
</body>
</html>