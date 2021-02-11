
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<%@include file="BandeauErreurs.jspf"%>
	<%@include file="../BandeauValidation.html"%>
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
					<p>Enchérissez sur un article</p>
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
				<form method="POST" action="<%=request.getContextPath()%>/Encherir">
				<div class="modal-body">
					
						<!--  Affichage de l'enchère actuelle -->
						<div class="row ml-2 mr-2">
							<p>
								Enchère actuelle : 
								<%
							String montantActuel = String.valueOf(request.getAttribute("montantActuel"));
							
							out.print(montantActuel);
							%>
							<input id="montantActuel" name="montantActuel" type="hidden"
									value="${requestScope.montantActuel}">
							</p>
							<%
							String idArticle = String.valueOf(request.getAttribute("idArticle"));
							%>
							<input id="idArticle" name="idArticle" type="hidden"
								value="${idArticle}">

							<!-- Value = enchère actuelle -->
						</div>
						<div class="row ml-2 mr-2">
							<!--  Champs de saisie de l'enchère de l'utilisateur -->
							<label for="enchereNew">Votre enchère :</label> <input
								class="form-control" type="text" name="enchereNew" id="enchereNew"
								autofocus="autofocus" required="required" />
						</div>
				</div>
				<!-- ****** -->
				<!-- footer -->
				<!-- ****** -->
				<div class="modal-footer">

						<!-- Bouton de fermeture de la modale sans prise en compte des saisies -->
						<button type="button"
							onclick="window.location.href = 'http://localhost:8080/ProjetEncheresENI/';"
							class="btn btn-primary" data-dismiss="modal">Retour</button>

						<!-- Bouton de validation des infos saisie dans la modale -->
						<button type="submit" class="btn btn-secondary" value="Connexion">Enchérir</button>
					
				</div>
			</div>
		</div>
	</div>
	</form>

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