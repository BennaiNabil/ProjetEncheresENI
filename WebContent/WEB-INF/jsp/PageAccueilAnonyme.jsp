<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>

<h1>Accueil - Utilisateur Anonyme</h1>

	<form method="GET" action="<%= request.getContextPath() %>/Connexion">
		<input type="submit" value="Connexion" />
	</form>

</body>
</html>