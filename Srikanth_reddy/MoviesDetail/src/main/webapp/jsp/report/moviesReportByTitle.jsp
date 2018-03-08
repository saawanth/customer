<jsp:include page="../common/navigationBar.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
    #imaginary_container{
    margin-top:20%; /* Don't copy this */
}
    .stylish-input-group .input-group-addon{
    background: white !important; 
}
.stylish-input-group .form-control{
	border-right:0; 
	box-shadow:0 0 0; 
	border-color:#ccc;
}
.stylish-input-group button{
    border:0;
    background:transparent;
}
</style>
</head>
<body>
<center> <h2>Report By Keyword</h2></center> 
    <div class="container">
  <div class="row">
    <div class="col-xs-12">
      <table extended functionality" class="table table-bordered table-hover dt-responsive">
        
       <thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>rating</th>
							<th>Genre</th>
							<th>Added By</th>
							
						</tr>
	</thead>

					<tbody>


							<c:forEach var="movieDetails" items="${movieDetails}">
							<tr>
								<td><c:out value="${movieDetails.movieId}" /></td>
								<td><c:out value="${movieDetails.title}" /></td>				
								<td><c:out value="${movieDetails.rating}" /></td>
								<td><c:out value="${movieDetails.genre}" /></td>
								<td><c:out value="${movieDetails.userDetails.username}" /></td>
							</tr>
						</c:forEach>

					</tbody>
    </table>
    <p>Average Rating:<c:out value="${averages}" />  </p>	
     <%--  <c:set var = "avr" value = "${average}"/>

      <fmt:parseNumber var = "i" type = "number" value = "${avr}" />
      <p>Parsed Number (1) : <c:out value = "${i}" /></p>
	 --%>	</div>			
		<div class="col-md-4">&nbsp;</div>
	</div>
</div>

</body>
</html>