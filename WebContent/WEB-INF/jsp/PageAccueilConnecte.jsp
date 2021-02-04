<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<!DOCTYPE html>
<html>
<head>
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

	<header>
		<div class="row">
			<div class="col-6">
				<div class="row">
					<div class="col-8">
						<a href="${pageContext.request.contextPath}"> <img
							alt="LOGO"
							src="<%=request.getContextPath()%>/resources/logoLOSNA.png">
						</a>
					</div>
					<div
						class="col-2"
						style="color: white;">
						<p class="mt-2">
							<i>${utilisateur.getPseudo()}</i>
						</p>
						<p class="mt-n2">${utilisateur.getCredit()}pts</p>
					</div>
				</div>
			</div>
			<div class="col-1,5">
				<button
					class="btn btn-primary mt-5 mr-2"
					type="submit">Enchères</button>
			</div>
			<div class="col-1,5">

				<form
					method="GET"
					action="<%=request.getContextPath()%>/MiseEnVente">
					<button
						class="btn btn-primary mt-5 mr-2"
						type="submit">Vendre</button>
				</form>
			</div>
			<div class="col-1,5">
				<button
					class="btn btn-primary mt-5 mr-2"
					type="submit">Mon profil</button>
			</div>
			<div class="col-1,5">

				<button
					class="btn btn-primary mt-5"
					type="submit">Déconnexion</button>
			</div>
		</div>
		<%@include file="/WEB-INF/BandeauErreurs.html"%>
		<!-- Inclusion du bandeau d'erreurs éventuelles -->
	</header>


	<p>${utilisateur.toString() }</p>



</body>
</html>