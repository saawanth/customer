<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Genre</th>
		</tr>

		<c:forEach var="movies" items=${movieDetails}>
			<tr>
				<td>${movieDetails.mid}</td>
				<td>${movieDetails.moviename}</td>
				<td>${movieDetails.genre}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>