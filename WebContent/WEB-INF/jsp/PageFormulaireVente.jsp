<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap + CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link
	rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />

<title>Nouvelle vente</title>
</head>
<body>
	<header>
		<div class="row align-items-center">
			<div class="col-4">
				<div class="col-6">
					<a href="${pageContext.request.contextPath}"> <img
						alt="LOGO"
						src="<%=request.getContextPath()%>/resources/logoLOSNA.png">
					</a>
				</div>
			</div>
			<div class="col-1,5 ml-auto">
				<button
					class="btn btn-primary mr-3"
					type="submit">Enchères</button>
			</div>
			<div class="col-1,5">
				<form
					method="GET"
					action="<%=request.getContextPath()%>/MiseEnVente">
					<button
						class="btn btn-primary mr-3"
						type="submit">Vendre</button>
				</form>
			</div>
			<div class="col-1,5">

				<button
					class="btn btn-primary mr-3"
					type="submit">Mon profil</button>
			</div>
			<div class="col-1,5">

				<button
					class="btn btn-primary mr-3"
					type="submit">Déconnexion</button>
			</div>

		</div>
	</header>

	<h1>Formulaire de vente des articles</h1>

	<div class="container">
		<form
			method="POST"
			action="<%=request.getContextPath()%>/MiseEnVente">

			<!-- Première ligne du formulaire : Article, catégorie et Prix de départ -->

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="nomArticle">Article :</label> <input
						class="form-control"
						type="text"
						name="nomArticle"
						id="nomArticle"
						autofocus="autofocus"
						required="required" />
				</div>
				<div class="form-group col-md-4">
					<label for="categorie">Catégorie:</label> <select
						class="form-control"
						name="categorie"
						id="categorie">
						<option value="">-- Sélectionnez une catégorie --</option>
						<option value="informatique">Informatique</option>
						<option value="ameublement">Ameublement</option>
						<option value="vêtement">Vêtement</option>
						<option value="sport">Sport & Loisir</option>
						<option value="animalerie">Animalerie</option>
						<option value="art">Art, Antiquités</option>
						<option value="auto">Auto, Moto</option>
						<option value="nautisme">Bateau, Voile, Nautisme</option>
						<option value="beaute">Beauté, Bien-être, Parfum</option>
						<option value="puericulture">Bébé, Puériculture</option>
						<option value="bijoux">Bijoux, Montres</option>
						<option value="bricolage">Bricolage</option>
						<option value="ceramique">Céramiques, Verres</option>
						<option value="collections">Collections</option>
						<option value="dvd">DVD, Cinéma</option>
						<option value="electromenager">Electroménager</option>
						<option value="image">Image, Son</option>
						<option value="instruments">Instruments de musique</option>
						<option value="jardin">Jardin, Terrasse</option>
						<option value="jeux">Jeux et Jouets</option>
						<option value="jeuxVideo">Jeux vidéo, Consoles</option>
						<option value="livres">Livres, BD, Revues</option>
						<option value="creatif">Loisirs créatifs</option>
						<option value="monnaies">Monnaies</option>
						<option value="musique">Musique, CD, Vinyls</option>
						<option value="photo">Photo, Caméscopes</option>
						<option value="telephonie">Téléphonie</option>
						<option value="timbres">Timbres</option>
						<option value="gastronomie">Vins et gastronomie</option>
					</select>
				</div>
				<div class="form-group col-md-2">
					<label for="prix">Prix de départ :</label> <input
						class="form-control"
						type="text"
						name="prix"
						id="prix"
						required="required" />
				</div>


			</div>


			<!-- Deuxième ligne du formulaire : Description de l'article -->


			<div class="form-row">
				<div class="form-group col">
					<label for="description">Description :</label> <input
						class="form-control"
						type="text"
						name="description"
						id="description"
						required="required" />
				</div>
			</div>

			<!-- Troisieme ligne du formulaire : Durée de l'enchère -->

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="debut">Début de l'enchère :</label> <input
						class="form-control"
						type="date"
						id=debut
						name="debut">
				</div>

				<div class="form-group col-md-6">
					<label for="fin">Fin de l'enchère :</label> <input
						class="form-control"
						type="date"
						id=fin
						name="fin">
				</div>
			</div>

			<!-- Quatrième ligne du formulaire : Lieu de retrait -->

			<div class="form-row">
				<div class="form-group col">
					<label for="retrait">Lieu du retrait :</label> <input
						class="form-control"
						type="text"
						name="retrait"
						id="retrait"
						required="required" />
				</div>
			</div>	

		<div class="form-row">
			<div class="form-group col-1">
			<input type="submit" value="Valider" class="btn btn-secondary"></input>
			</div>	
			<div class="form-group col-1">
			<a href="<%=request.getContextPath()%>"><input type="button" class="btn btn-secondary" value="Annuler"/></a>
			</div>
		</div>
		

		</form>
	</div>


</body>
</html>