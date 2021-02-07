<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="fr.eni.encheres.bo.Enchere"%>
	<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification de mon profil</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">

<meta charset="UTF-8">
<link
	rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />
<title>Accueil</title>
</head>
<body>

	<%@include file="FragmentHeader.jspf"%>
	<%@include file="../BandeauErreurs.html"%>
	
	<form
		method="POST"
		action="<%=request.getContextPath()%>/ModifierMonProfil">
		<fieldset>

			<!-- Form Name -->
			<legend>Formulaire de modification de profil</legend>

			<!-- Text input-->
			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="pseudo">Pseudo: </label>
				<div class="col-md-4">
					<input
						value="${utilisateur.getPseudo() }"
						id="pseudo"
						name="pseudo"
						type="text"
						placeholder=""
						class="form-control input-md">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="nom">Nom</label>
				<div class="col-md-4">
					<input
						id="nom"
						name="nom"
						type="text"
						placeholder=""
						value="${utilisateur.getNom() }"
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="prenom">Prenom</label>
				<div class="col-md-4">
					<input
						id="prenom"
						name="prenom"
						type="text"
						placeholder=""
						value="${utilisateur.getPrenom() }"
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="email">Email</label>
				<div class="col-md-4">
					<input
						id="email"
						name="email"
						type="text"
						placeholder=""
						value="${utilisateur.getEmail() }"
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="rue">Rue</label>
				<div class="col-md-4">
					<input
						id="rue"
						name="rue"
						type="text"
						placeholder=""
						value="${utilisateur.getRue() }"
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="codepostal">Code postal</label>
				<div class="col-md-4">
					<input
						id="codepostal"
						name="codepostal"
						type="text"
						placeholder=""
						value="${utilisateur.getCodePostal() }"
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="telephone">Téléphone</label>
				<div class="col-md-4">
					<input
						id="telephone"
						name="telephone"
						type="text"
						placeholder=""
						value="${utilisateur.getTelephone() }"
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="ville">Ville</label>
				<div class="col-md-4">
					<input
						id="ville"
						name="ville"
						type="text"
						placeholder=""
						value="${utilisateur.getVille() }"
						class="form-control input-md">

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="btnValider"></label>
				<div class="col-md-4">
					<button
						id="btnValider"
						name="btnValider"
						class="btn btn-primary">Valider</button>
				</div>

			</div>

		</fieldset>
	</form>

	<form
		method="GET"
		action="<%=request.getContextPath()%>/SupprimerMonCompte">
		<div class="col-md-4">
			<button
				id="btnSupprimer"
				name="btnSupprimer"
				class="btn btn-danger">Supprimer votre profil</button>
		</div>
	</form>
	<%@include file="FragmentFooter.jspf"%>
</body>
</html>