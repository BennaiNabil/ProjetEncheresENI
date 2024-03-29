<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<%@include file="BandeauErreurs.jspf"%>
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
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form class="md-4 form-inline" method="GET"
					action="<%=request.getContextPath()%>/ModifierMonProfil">
					<button class="btn btn-secondary">Modifier</button>
				</form>
			</div>
		</div>
	</div>
	</div>
	</div>
	<%@include file="FragmentFooter.jspf"%>
</body>
</html>