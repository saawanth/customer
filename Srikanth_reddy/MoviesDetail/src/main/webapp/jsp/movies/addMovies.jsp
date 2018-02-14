
<jsp:include page="../common/navigationBar.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE section PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<section>


	<div class="container">

		<div class="row">
			<div class="col-md-3">&nbsp;</div>
			<div class="col-md-6">

				<form action="<%=request.getContextPath()%>/addMovieDetails"
					method="post" >
					<div class="message error">
						<c:out value="${error}" />
					</div>
					<div class="message success">
					<c:out value="${success}" />
				</div>
					<input class="form-control input-lg" name="title"
						placeholder="Movie Title" required="" type="text" value="" /><br><br>
				
				<input class="form-control input-lg" name="genere"
						placeholder="Genere" required="" type="text" value="" /><br><br>
						
						<input class="form-control input-lg" name="rating"
						placeholder="Rating" required="" type="number" value=""  step="0.1"/><br><br>
							<input class="form-control input-lg" name="addedBy"
						placeholder="addedBy" required="" type="text" value="" /><br><br>
				
					<div align="form-control input-lg">
						<button class="btn btn-lg btn-primary" name="go" type="submit">Submit</button>
					</div>
				</form>
			</div>
			<div class="col-md-3">&nbsp;</div>
		</div>

		

</section>

</body>
</html>