<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
<title>Student Information</title>
</head>
<body>
Customer is confirmed: ${customer.firstName} ${customer.lastName}
<br><br>
Free Passes: ${customer.freePasses}
<br><br>
Postal Code: ${customer.postalCode}
</body>

</html>