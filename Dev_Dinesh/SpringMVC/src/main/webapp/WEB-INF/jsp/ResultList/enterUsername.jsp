<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



	<div class="container">

		<div class="row">
			<div class="col-md-3">&nbsp;</div>
			<div class="col-md-6">

				<form action="<%=request.getContextPath()%>/moviesByUsername"
					method="get" >
					
					<input class="form-control input-lg" name="userId" placeholder="User Id" required="" type="text" value="" /><br><br>
				
				
					<div align="form-control input-lg">
						<button class="btn btn-lg btn-primary" name="go" type="submit">Submit</button>
					</div>
				</form>
			</div>
			<div class="col-md-3">&nbsp;</div>
		</div>
</div>
		

</body>
</html>