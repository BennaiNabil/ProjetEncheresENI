<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="fr.eni.encheres.bo.Enchere"%>
	<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>	

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Accueil</title>

<!-- Bootstrap + CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AccueilStyle.css"/>


</head>
<body>
	
		<%
		boolean isPageAnonyme = true;
		%>
		<%@include file="FragmentHeader.jspf" %>
		<%@include file="../BandeauErreurs.html" %>
	
			

		<!-- <main>

			Titre

			<h1 class="text-center">Liste des ench�res</h1>

			Recherche

			<div class="row mt-5">
				<div class="col-6">
					<label for="">Rechercher une ench�re</label> <input type="text">
				</div>
				<div class="col-1">
					<p>OU/ET</p>
				</div>
				<div class="col-4">
					<label for="">Dans la cat�gorie</label> <input type="text">
				</div>
				<div class="col-1">
					<button class="btn btn-secondary" type="button">Recherche</button>
				</div>
			</div>


		</main> -->

		<!--<footer>-->
		<!--	<footer class="bg-light text-center text-lg-start">-->
		<!--		&lt;!&ndash; Copyright &ndash;&gt;-->
		<!--		<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">-->
		<!--			Copyright � 2021 L�a Georges et Nabil-->
		<!--		</div>-->
		<!--		&lt;!&ndash; Copyright &ndash;&gt;-->
		<!--	</footer>-->
		<!--</footer>-->

	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
</body>
</html>