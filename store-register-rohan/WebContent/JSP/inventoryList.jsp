
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<title>Store Inventory</title>
</head>
<body>
 <body bgcolor="#E6E6FA">
	</body>
	<h1>Store Register</h1>
<form method="post" action="checkout">
        <fieldset>
                <legend>Select the Items available from List</legend>
                		
                        <input type="checkbox" name="inventory" value="PC1033" />PC1033 <br />
                        <input type="checkbox" name="inventory" value="GENERIC PROCESSOR" />GENERIC PROCESSOR<br />
                        <input type="checkbox" name="inventory" value="KEYBOARD" />Keyboard<br />
                        <input type="checkbox" name="inventory" value="LCD" />LCD<br />
                        <input type="checkbox" name="inventory" value="GENERIC MOTHERBOARD" />Generic Motherboard<br />
                        <input type="submit" value="Submit now" />
        </fieldset>
</form>
 
</body>
</html>