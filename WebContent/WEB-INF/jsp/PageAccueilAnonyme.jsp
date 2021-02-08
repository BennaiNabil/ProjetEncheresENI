<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>


<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Accueil</title>

<!-- Bootstrap + CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link
	rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />
</head>
<body>

	<%-- <%@include file="FragmentHeader.jspf"%>
	<%@include file="../BandeauErreurs.html"%>
 --%>
	<form
		method="POST"
		action="<%=request.getContextPath()%>/AfficherEncheresCourantes">
		<select
			name="categorie"
			id="categorie">
			<option value="">-- Sélectionnez une catégorie --</option>
			<c:forEach
				items="${listeCategories}"
				var="cate">
				<option value="${cate.getNoCategorie()}">${cate.getLibelle()}</option>
			</c:forEach>
		</select>
		<button
			class="btn btn-primary"
			type="submit">Rechercher</button>
	</form>

	<%
	boolean estPremiereRecherche = true;
	%>

	<c:choose>
		<c:when test="${listeInfosEncheres.size() > 0 || estPremiereRecherche }">
			<div class="row">
				<c:forEach
					items="${listeInfosEncheres}"
					var="infos">
					<div class="col-3">
						<div
							class="card m-5"
							style="width: 18rem; border: 2px solid black;">
							<div class="card-body">
								<c:forEach
									var="i"
									begin="0"
									end="${infos.size()-1 }">
									<p>${entetes.get(i) }${infos.get(i) }</p>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<%
			estPremiereRecherche = false;
			%>
		</c:when>
		<c:otherwise>
			<h1>Pas de résultat</h1>
		</c:otherwise>
	</c:choose>



	<%@include file="FragmentFooter.jspf"%>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>