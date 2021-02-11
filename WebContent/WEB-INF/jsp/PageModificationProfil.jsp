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
<title>Modification de mon profil</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">

<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />
<title>Modification de profil</title>
</head>
<body>

	<%@include file="FragmentHeader.jspf"%>
	<%@include file="BandeauErreurs.jspf"%>

	<h4 class="text-center">Modification du profil</h4>
	<div class="container-fluid">
		<form method="POST"
			action="<%=request.getContextPath()%>/ModifierMonProfil">
			<fieldset>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<label for="textinput">Identité</label>
						<div class="input-group md-4 form-inline">
							<input value="${utilisateur.getNom() }" id="nom" name="nom"
								type="text" class="form-control"> <input
								value="${utilisateur.getPrenom() }" id="prenom" name="prenom"
								type="text" class="form-control">
						</div>
						<label class="input-group md-1 form-inline" for="textinput">Pseudo</label>
						<div class="form-group md-4 form-inline">
							<input value="${utilisateur.getPseudo() }" id="pseudo"
								name="pseudo" type="text" class="form-control">
						</div>

						<label class="input-group md-1 form-inline" for="textinput">E-Mail</label>
						<div class="form-group md-4 form-inline">
							<input value="${utilisateur.getEmail() }" id="email" name="email"
								type="email" class="form-control">
						</div>

						<label for="textinput">Téléphone</label>
						<div class="form-group md-4 form-inline">
							<input value="${utilisateur.getTelephone() }" id="telephone"
								name="telephone" type="text" class="form-control">
						</div>

						<label for="textinput">Adresse</label>
						<div class="input-group md-4 form-inline">
							<input value="${utilisateur.getRue() }" class="form-control"
								id="rue" name="rue" type="text">
						</div>
						<div class="input-group md-4 form-inline">
							<input value="${utilisateur.getCodePostal() }"
								class="form-control" id="codepostal" name="codepostal"
								type="text"> <input value="${utilisateur.getVille() }"
								class="form-control" id="ville" name="ville" type="text">
						</div>

						<label for="textinput fst-italic">Modifiez les valeurs
							correspondantes puis validez</label> <label
							class="col-md-4 form-inline control-label" for="btnValider"></label>
						<div class="col-md-4 form-inline">
							<button type="submit" id="btnValider" name="btnValider"
								class="btn btn-secondary">Valider</button>
						</div>
						</form>
						<form method="GET"
							action="<%=request.getContextPath()%>/SupprimerMonCompte">
							<button id="btnSupprimer" name="btnSupprimer"
								class="btn btn-danger">Supprimer votre profil</button>
					</div>
	</div>
	<div class="col-md-4"></div>
	</div>
	</fieldset>
	</form>
	<%@include file="FragmentFooter.jspf"%>
</body>
</html>