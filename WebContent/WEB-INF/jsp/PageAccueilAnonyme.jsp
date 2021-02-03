<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="fr.eni.encheres.bo.Enchere"%>
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

<%	
	List<Enchere> listeEncheres = (List<Enchere>) request.getAttribute("listeEncheres");
	if(listeEncheres!=null && listeEncheres.size()>0)
	{%>
		<ul>
		<%
		for (Enchere enchereCourante:listeEncheres)
		{
	%>
	
		<p> <%= enchereCourante.toString() %></p>
		
	<%
		}
		%>
		</ul>
	<%
	}
	%>


		</header>

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

	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
</body>
</html>