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
<title>Inscription</title>
<!-- Bootstrap + CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AccueilStyle.css"/>

<!-- <link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet"> -->
</head>
<body>
	<div class="container">
	<header>
			<div class="row">
					<div class="col-8">
					<a href="${pageContext.request.contextPath}">
						<img
							alt="LOGO"
							src="<%=request.getContextPath()%>/resources/logoLOSNA.png">
					</a>	
					</div>
					<div class="col-2">
						<form
							method="GET"
							action="<%=request.getContextPath()%>/Inscription">
	
							<button
								class="btn btn-primary mt-5"
								type="submit">Inscription</button>
						</form>
					</div>
					<div class="col-2">
						<form
							method="GET"
							action="<%=request.getContextPath()%>/Connexion">
	
							<button
								class="btn btn-primary mt-5"
								type="submit">Connexion</button>
						</form>
					</div>
				</div>
			<%@include file="/WEB-INF/BandeauErreurs.html" %> <!-- Inclusion du bandeau d'erreurs éventuelles -->
		</header>
	</div>
	<form method="POST" class="form-horizontal" action="<%= request.getContextPath() %>/Inscription">
		<fieldset>

			<legend>Inscription</legend>

			<div class="form-group">
				<label for="textinput">Pseudo</label> <input
					id="pseudo"
					name="pseudo"
					type="text"
					class="form-control input-md">
			</div>

			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="textinput">Nom</label> <input
					id="nom"
					name="nom"
					type="text"
					class="form-control input-md">
			</div>

			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="textinput">Prénom</label> <input
					id="prenom"
					name="prenom"
					type="text"
					class="form-control input-md">
			</div>

			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="textinput">E-mail</label> <input
					id="email"
					name="email"
					type="text"
					class="form-control input-md">
			</div>

			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="textinput">Téléphone</label> <input
					id="tel"
					name="tel"
					type="text"
					class="form-control input-md">
			</div>

			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="textinput">Rue</label> <input
					id="rue"
					name="rue"
					type="text"
					class="form-control input-md">
			</div>

			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="textinput">Code Postal</label> <input
					id="codePostal"
					name="codePostal"
					type="text"
					class="form-control input-md">
			</div>

			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="textinput">Ville</label> <input
					id="ville"
					name="ville"
					type="text"
					class="form-control input-md">
			</div>

			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="textinput">Mot de passe</label> <input
					id="mdp"
					name="mdp"
					type="text"
					class="form-control input-md">
			</div>

			<div class="form-group">
				<label
					class="col-md-4 control-label"
					for="textinput">Confirmation</label> <input
					id="conf"
					name="conf"
					type="text"
					class="form-control input-md">
			</div>

			
			<div class="form-group">
				<button
					id="singlebutton"
					name="singlebutton"
					class="btn btn-primary">Valider</button>
			</div>
		


		</fieldset>
	</form>

</body>
</html>