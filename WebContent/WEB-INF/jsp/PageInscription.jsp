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
<title>Inscription</title>
<!-- Bootstrap + CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />

<!-- <link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet"> -->
</head>
<body>
	<%@include file="FragmentHeader.jspf"%>
	<%@include file="BandeauErreurs.jspf"%>


	<h4 class="text-center mt-4">Formulaire d'inscription</h4>
	<div class="container-fluid">
		<form method="POST"
			action="<%= request.getContextPath() %>/Inscription">
			<fieldset>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<label for="textinput">Identité</label>
						<div class="input-group md-4 form-inline">
							<input id="nom" name="nom" type="text" class="form-control"
								placeholder="Nom" maxlength="30"> <input id="prenom"
								name="prenom" type="text" class="form-control"
								placeholder="Prénom" maxlength="30" required>
						</div>
						<label for="textinput" class="mt-3">Pseudo</label>
						<div class="form-group md-4 form-inline">
							<input id="pseudo" name="pseudo" type="text" class="form-control"
								placeholder="Pseudo" maxlength="30" required>
						</div>

						<label class="input-group md-1 form-inline" for="textinput">E-Mail</label>
						<div class="form-group md-4 form-inline">
							<input id="email" name="email" type="email" class="form-control"
								placeholder="E-mail" maxlength="20"
								pattern="/^([\w-\.]+)@((?:[\w]+\.)+)([a-zA-Z]{2,4})/i"
								oninvalid="this.setCustomValidity('Ce n'est pas un format de courriel correct')"
								oninput="this.setCustomValidity('')" required>
						</div>

						<label for="textinput">Téléphone</label>
						<div class="form-group md-4 form-inline">
							<input id="tel" name="tel" type="text" class="form-control"
								placeholder="N° de téléphone" maxlength="15"
								pattern="(0|\+33)[1-9]( *[0-9]{2}){4}"
								oninvalid="this.setCustomValidity('Le téléphone doit faire 10 chiffres éventuellement précédé de +33 (sans le 0 dans ce cas)')"
								oninput="this.setCustomValidity('')">
						</div>

						<label for="textinput">Adresse</label>
						<div class="input-group md-4 form-inline">
							<input class="form-control" id="rue" name="rue" type="text"
								placeholder="N° et rue" maxlength="30" required>
						</div>
						<div class="input-group md-4 form-inline">
							<input class="form-control" id="codePostal" name="codePostal"
								type="text" placeholder="Code Postal" maxlength="10" required> <input
								class="form-control" id="ville" name="ville" type="text"
								placeholder="Ville" maxlength="30" required>
						</div>

						<label for="textinput" class="mt-3">Mot de passe</label>
						<div class="input-group md-4 form-inline">
							<input id="mdp" name="mdp" type="password" class="form-control md-3"
								placeholder="Mot de passe" maxlength="30" required> <input
								id="conf" name="conf" type="password" class="form-control md-3"
								placeholder="Confirmation mot de passe" maxlength="30" required>
						</div>

						<div class="fst-italic text-danger">
							Tous les champs sont obligatoires</br>
						</div>
						<div class="fst-italic text-light text-center bg-dark mt-4">Un crédit de 100
							points vous est offert !</div>
						</row>
						&nbsp;
						<row>
						<div class="form-group md-4 form-inline">
							<button type="submit" class="btn btn-secondary">Valider</button>
						</div>
						</row>
					</div>
					<div class="col-md-4"></div>
			</fieldset>
		</form>

		<%@include file="FragmentFooter.jspf"%>
</body>
</html>