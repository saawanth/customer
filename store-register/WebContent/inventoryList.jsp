<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<title>Store Inventory</title>
</head>
<body>
 
	<h1>Items</h1>
 
	<c:forEach items="${list}" var="item">
		<p>
			${item.name} : $${item.price} : ${item.category}
		</p>
	</c:forEach>
 
</body>
</html>