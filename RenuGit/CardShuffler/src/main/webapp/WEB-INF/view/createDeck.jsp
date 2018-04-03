<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Deck Creation Form</title>
<body>
<i>Fill out the form. (*) means the field is required! </i>
<form action="deckCreated" method = "GET">
Deck Name <input type = "text" name = "deckName"
placeholder="What is the name of the deck?" />
<br><br>
<input type="submit" value="submit">
</form>
</body>
</html>