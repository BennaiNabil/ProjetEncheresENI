<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap + CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />

<title>Nouvelle vente</title>
</head>
<body>
	<header>
		<div class="row align-items-center">
			<div class="col-4">
				<div class="col-6">
					<a href="${pageContext.request.contextPath}"> <img alt="LOGO"
						src="<%=request.getContextPath()%>/resources/logoLOSNA.png">
					</a>
				</div>
			</div>
			<div class="col-1,5 ml-auto">
				<button class="btn btn-primary mr-3" type="submit">Enchères</button>
			</div>
			<div class="col-1,5">
				<form method="GET"
					action="<%=request.getContextPath()%>/MiseEnVente">
					<button class="btn btn-primary mr-3" type="submit">Vendre</button>
				</form>
			</div>
			<div class="col-1,5">

				<button class="btn btn-primary mr-3" type="submit">Mon
					profil</button>
			</div>
			<div class="col-1,5">

				<button class="btn btn-primary mr-3" type="submit">Déconnexion</button>
			</div>

		</div>
	</header>
	<%@include file="../BandeauErreurs.html"%>
	<%@include file="../BandeauValidation.html"%>

	<div class="container">
		<form method="POST" action="<%=request.getContextPath()%>/MiseEnVente">

			<!-- Première ligne du formulaire : Article, catégorie et Prix de départ -->

			<div class="form-row pt-5">
				<div class="form-group col-md-6">
					<label for="nomArticle">Article :</label> <input
						class="form-control" type="text" name="nomArticle" id="nomArticle"
						autofocus="autofocus" required="required" maxlength="30"
						placeholder="30 caractères maximum" />
				</div>
				<div class="form-group col-md-4">
					<label for="categorie">Catégorie:</label> <select
						class="form-control" name="categorie" id="categorie">
						<option value="">-- Sélectionnez une catégorie --</option>
						<c:forEach items="${listeCategories}" var="categorie">
							<option selected value="${categorie.getNoCategorie()}">${categorie.getLibelle()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-2">
					<label for="prix">Prix de départ :</label> <input
						class="form-control" type="text" name="prix" id="prix"
						required="required" />
				</div>
			</div>

			<!-- Deuxième ligne du formulaire : Description de l'article -->

			<div class="form-row">
				<div class="form-group col">
					<label for="description">Description :</label> <input
						class="form-control" type="text" name="description"
						id="description" required="required" maxlength="300"
						placeholder="300 caractères maximum" />
				</div>
			</div>

			<!-- Troisieme ligne du formulaire : Durée de l'enchère -->

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="debut">Début de l'enchère :</label> <input
						class="form-control" type="date" id=debut name="debut">
				</div>

				<div class="form-group col-md-6">
					<label for="fin">Fin de l'enchère :</label> <input
						class="form-control" type="date" id=fin name="fin">
				</div>
			</div>

			<!-- Quatrième ligne du formulaire : Lieu de retrait -->

			<div class="form-row">
				<div class="form-group col">
					<label for="retrait">Lieu du retrait :</label> <input
						class="form-control col" type="text" name="rue" id="rue"
						required="required" placeholder="Rue" maxlength="30" /> <input
						class="form-control col" type="text" name="codePostal"
						id="codePostal" required="required" placeholder="Code Postal"
						maxlength="5" /> <input class="form-control col" type="text"
						name="ville" id="ville" required="required" placeholder="Ville"
						maxlength="30" />
				</div>
			</div>


			<div class="form-row">
				<div class="form-group col-1,5">
					<input type="submit" value="Valider" class="btn btn-secondary"></input>
				</div>
				<div class="form-group col-1,5">
					<input type="reset" value="Réinitialiser" class="btn btn-secondary"></input>
				</div>
				<div class="form-group col-1,5">
					<a href="<%=request.getContextPath()%>"><input type="button"
						class="btn btn-secondary" value="Annuler" /></a>
				</div>
			</div>

			<label for="photo">Photo de l'article:</label> <input
				type="file" id="photo" name="photo" accept="image/png, image/jpeg">


		</form>
	</div>


</body>
</html>