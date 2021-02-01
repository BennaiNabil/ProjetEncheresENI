<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>

<h1>Page de connexion</h1>

<form method="POST" action="<%= request.getContextPath() %>/Connexion">

	<!--  Champs de saisie de l'identifiant utilisateur -->

		<label for="identifiant">Identifiant :</label>
		<input type="text" name="identifiant" id="identifiant" autofocus="autofocus" required="required"/>
		
	<!--  Champs de saisie du mdp utilisateur -->	
		
		<label for="mdp">Mot de passe :</label>
		<input type="password" name="mdp" id="mdp" required="required"/>
		
	<!-- Bouton "Connexion" -->		
		
		<input type="submit" value="Connexion" />
		
</form>


</body>
</html>