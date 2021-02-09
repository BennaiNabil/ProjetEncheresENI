<%@page import="jdk.internal.misc.FileSystemOption"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />
<meta charset="UTF-8">
<title>Participation à l'enchère</title>
</head>
<body>
	<!-- Script JAVASCRIPT -->
	<!-- Script d'intégration de JQuery pour les méthodes d'affichage des modales -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

	<!-- Script d'affichage de la fenetre modale au chargement de la page -->
	<script>
		$(document).ready(function() {
			$("#fenetreModale").modal('show');
		});
	</script>
</head>
<body>

	<%@include file="../BandeauErreurs.html"%>
	<!-- ************** -->
	<!-- Fenetre modale -->
	<!-- ************** -->
	<div class="modal fade" id="fenetreModale">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- ****** -->
				<!-- Header -->
				<!-- ****** -->
				<div class="modal-header">
					<p>Faire une nouvelle enchère</p>
				</div>
				<!-- **** -->
				<!-- body -->
				<!-- **** -->
<%-- 				<%
				if (erreurEnchère == "true") {
				%>
				<div class="alert alert-danger" role="alert">Les données
					saisies sont incorrectes</div>
				<%
				}
				%> --%>
				<div class="modal-body">
					<form method="POST" action="<%=request.getContextPath()%>/Encherir">
						<!--  Affichage de l'enchère actuelle -->
						<div class="row">
							<p>Enchère actuelle : <%String montantActuel = String. valueOf(request.getAttribute("montantActuel"));
							out.print(montantActuel);
							%></p>
							<%String idArticle = String.valueOf(request.getAttribute("idArticle"));
							%>
							<input
											id="idArticle"
											name="idArticle"
											type="hidden"
											value="${idArticle}">
							
							<!-- Value = enchère actuelle -->
						</div>
						<div class="row">
							<!--  Champs de saisie de l'enchère de l'utilisateur -->
							<label class="col-4" for="enchereNew">Votre enchère :</label> <input
								class="col-6" type="text" name="enchereNew" id="enchereNew" autofocus="autofocus"
								required="required" />
						</div>
					</form>
				</div>
				<!-- ****** -->
				<!-- footer -->
				<!-- ****** -->
				<div class="modal-footer">
					<form method="POST" action="<%=request.getContextPath()%>/Encherir">
						<!-- Bouton de fermeture de la modale sans prise en compte des saisies -->
						<button type="button"
							onclick="window.location.href = 'http://localhost:8080/ProjetEncheresENI/';"
							class="btn btn-primary" data-dismiss="modal">Retour</button>

						<!-- Bouton de validation des infos saisie dans la modale -->
						<button type="submit" class="btn btn-primary" value="Connexion">Enchérir</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$("#fenetreModale").modal('close');
		});
	</script>


	<!-- Intégration de bootstrap javascript -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>



</body>
</html>