<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<%@include file="../fragments/fragmentStyle.jspf"%>
</head>
<body>

	<header>
		<div class="row">
			<div class="col-8">
				<img
					alt="LOGO"
					src="<%=request.getContextPath()%>/resources/logoLOSNA.png">
			</div>
			<div class="col-2">
				<button
					class="btn btn-primary mt-5 mr-5"
					type="button">Inscription</button>
			</div>
			<div class="col-2">
				<button
					class="btn btn-primary mt-5"
					type="button">Connexion</button>
			</div>
		</div>
	</header>

	<main>

		<!--Titre-->
		<div class="container">
			<h1 class="text-center">Liste des enchères</h1>
		</div>

		<!--Recherche-->
		<div class="container mt-5">
			<div class="row">
				<div class="col-6">
					<label for="">Rechercher une enchère</label> <input type="text">
				</div>
				<div class="col-1">
					<p>OU/ET</p>
				</div>
				<div class="col-4">
					<label for="">Dans la catégorie</label> <input type="text">
				</div>
				<div class="col-1">
					<button
						class="btn btn-secondary"
						type="button">Recherche</button>
				</div>
			</div>
		</div>


	</main>

	<!--<footer>-->
	<!--	<footer class="bg-light text-center text-lg-start">-->
	<!--		&lt;!&ndash; Copyright &ndash;&gt;-->
	<!--		<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">-->
	<!--			Copyright © 2021 Léa Georges et Nabil-->
	<!--		</div>-->
	<!--		&lt;!&ndash; Copyright &ndash;&gt;-->
	<!--	</footer>-->
	<!--</footer>-->


</body>
</html>