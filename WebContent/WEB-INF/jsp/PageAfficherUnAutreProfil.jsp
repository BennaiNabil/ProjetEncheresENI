<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />

</head>
<body>

	<%@include file="FragmentHeader.jspf"%>
	</form>
	<%@include file="../BandeauErreurs.html"%>
	<h4 class="text-center">Profil de ${utilisateur.getPseudo() }</h4>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="md-4 form-inline">Pseudo :
					${utilisateur.getPseudo() }</div>
				<div class="md-4 form-inline">Prénom :
					${utilisateur.getPrenom() }</div>
				<div class="md-4 form-inline">Nom : ${utilisateur.getNom() }</div>
				<div class="md-4 form-inline">E-Mail :
					${utilisateur.getEmail() }</div>
				<div class="md-4 form-inline">Adresse: ${utilisateur.getRue() },
					${utilisateur.getCodePostal() } ${utilisateur.getVille() }</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		
	</div>
	
	<%@include file="FragmentFooter.jspf"%>
</body>
</html>