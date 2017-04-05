

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<title>Store Inventory</title>
</head>
<body>
 
	<h1>Items</h1>
<form method="post" action="checkout">
        <fieldset>
                <legend>What is Your Favorite Pet?</legend>
                        <input type="checkbox" name="inventory" value="PC1033" />PC1033 <br />
                        <input type="checkbox" name="inventory" value="GenericProcessor" />GenericProcessor<br />
                          <input type="checkbox" name="inventory" value="Keyboard" />Keyboard<br />
                            <input type="checkbox" name="inventory" value="LCD" />LCD<br />
                        <input type="checkbox" name="inventory" value="GenericMotherboard" />GenericMotherboard<br />
                        <input type="submit" value="Submit now" />
        </fieldset>
</form>
 
</body>
</html>