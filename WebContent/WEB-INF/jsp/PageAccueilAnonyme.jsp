<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Accueil</title>

<!-- Bootstrap + CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />
</head>
<body>
	<!-- inclusion des jsp concernant le bandeau d'entête et l'affichage des erreurs -->
	<%@include file="FragmentHeader.jspf"%>
	<%@include file="BandeauErreurs.jspf"%>
	
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<p class="text-center">
				<form method="POST"
					action="<%=request.getContextPath()%>/AfficherEncheresCourantes"
					class="form-inline">
					<!-- Première ligne du formulaire : barre de recherche [catégorie - recherche - trier par - bouton submit]-->

					<div class="form-group col-auto">
						<select name="categorie" id="categorie">
							<option value="">-- Sélectionnez une catégorie --</option>
							<c:forEach items="${listeCategories}" var="cate">
								<option
									${ categorieChoisie == cate.getNoCategorie() ? "selected" : ""}
									value="${cate.getNoCategorie()}">${cate.getLibelle()}</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group col-auto">
						<label class="mr-2">ET/OU Article : </label> <input type="text"
							id="nomArticle" name="nomArticle"
							value="${nomArticleChoisi !=null? nomArticleChoisi: null }"
							placeholder="mots clés">
					</div>

					<div class="form-group col-auto">
						<select name="tri" id="tri">
							<option value="triNone">-- Trier par --</option>
							<option value="triDate">Tri par date</option>
							<option value="triNom">Tri par nom</option>
						</select>
					</div>
					<div class="form-group col-auto">
						<button class="btn btn-primary" type="submit">Rechercher</button>
					</div>
				</form>
				</p>
			</div>
		</div>
		<div class="col-md-1"></div>


		<%
			boolean estPremiereRecherche = true;
		%>
	</div class="container">
	<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-12">
	<div class="form-row">
		<c:choose>
			<c:when
				test="${listeInfosEncheres.size() > 0 || estPremiereRecherche }">
				<div class="row form-inline text-left">
					<c:forEach items="${listeInfosEncheres}" var="infos">
						<div class="card md-7 form-inline text-left m-3 mx-auto"
							style="width: 18rem; border: 2px solid black; border-radius: 10px">
							<div class="card-body text-left">
								<form method="GET"
									action="<%=request.getContextPath()%>/Encherir"
									class="text-left">
									<c:forEach var="i" begin="0" end="${infos.size()-1 }">
										<c:if test="${i == 4}">
											<a
												href="<%=request.getContextPath()%>/Profil?pseudo=${infos.get(i)}">${infos.get(i)}</a>
										</c:if>
										<c:if test="${i != 4}">
											<c:set var="string"
												value="${fn:substring(infos.get(i), 0, 25)}" />
										</c:if>
										<c:if test="${i == 1}">
											<c:set var="string2" value="${string} ..." />
											<c:set var="string" value="${string2}" />
										</c:if>
										<p>${string}</p>
									</c:forEach>
									<input id="idArticle" name="idArticle" type="hidden"
										value="${infos.get(infos.size()-1)}">
									<!-- Bouton menant à Encherir -->
									<c:set var="connect" value="${sessionScope.connected}">
									</c:set>
									<c:if test="${connect != null}">
										<button type="submit" class="btn btn-primary" value="encherir">Enchérir</button>
									</c:if>
								</form>
							</div>
						</div>
					</c:forEach>
				</div>

			</c:when>
			<c:otherwise>
	</div>
	</div>
	</div>
	<div class="container-fluid">
		<p class="text-center">
		<h6 class="text-center">Pas de résultats</h6>
		</p>
	</div>
	</div>
	</c:otherwise>
	</c:choose>

	<%@include file="FragmentFooter.jspf"%>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>