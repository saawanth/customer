<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
								<td><c:out value="${movieDetails.mid}" /></td>
								<td><c:out value="${movieDetails.title}" /></td>				
								<td><c:out value="${movieDetails.genre}" /></td>
							
							</tr>
						</c:forEach>

					</tbody>
    </table>	
		</div>			
		<div class="col-md-4">&nbsp;</div>
	</div>
</div>
</body>
</html>