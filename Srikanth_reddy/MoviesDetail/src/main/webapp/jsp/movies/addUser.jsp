
<jsp:include page="../common/navigationBar.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<section>


	<div class="container">

		<div class="row">
			<div class="col-md-3">&nbsp;</div>
			<div class="col-md-6">

				<form action="<%=request.getContextPath()%>/addUserDetails"
					method="post" >
					<div class="message error">
						<c:out value="${error}" />
					</div>
					<div class="message success">
					<c:out value="${success}" />
				</div>
					<input class="form-control input-lg" name="username"
						placeholder="User Name" required="" type="text" value="" /><br><br>
				
				<input class="form-control input-lg" name="age"
						placeholder="Age" required="" type="number" value="" /><br><br>
				
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