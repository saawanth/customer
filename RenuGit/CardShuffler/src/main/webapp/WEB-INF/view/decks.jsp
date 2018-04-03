<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Deck Creation</title>
</head>
<body>
Below are the list of Decks available:
<ul>
<c:forEach var="item" items= "${deckList}" >
<li> ${item} </li>
</c:forEach>
  </ul> 
<br><br>
</body>
</html>
