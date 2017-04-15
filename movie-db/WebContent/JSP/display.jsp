<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie store</title>
</head>
<body>
<c:forEach items="${movie}" var="item">
  

 

<font size='5' color='blue'>The movie rated by the user is ${username}</font><br>
<font size='5' color='blue'>${item.getMoviename()}</font><br>
</c:forEach>

</body>
</html>