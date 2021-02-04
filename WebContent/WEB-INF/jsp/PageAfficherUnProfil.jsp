<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link
	rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />

</head>
<body>

	<%
		boolean isPageAnonyme = false;
	%>
	<%@include file="FragmentHeader.jspf"%>

	<div class="container mt-5">
		<h2>Profil de : ${utilisateur.getPseudo() }</h2>
		<ul>
			<li>Pseudo: ${utilisateur.getPseudo() }</li>
			<li>Nom: ${utilisateur.getNom() }</li>
			<li>Prénom: ${utilisateur.getPrenom() }</li>
			<li>E-mail: ${utilisateur.getEmail() }</li>
			<li>Téléphone: ${utilisateur.getTelephone() }</li>
			<li>Rue: ${utilisateur.getRue()  }</li>
			<li>Code Postal ${utilisateur.getCodePostal() }</li>
			<li>Ville: ${utilisateur.getVille() }</li>
		</ul>

		<div class="row">
			<button class="btn btn-secondary">Modifier</button>
			<button class="btn btn-secondary">Retour</button>
		</div>
	</div>
</body>
</html>