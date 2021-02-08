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

	<div
		class="card"
		style="width: 18rem;">
		<ul class="list-group list-group-flush">
			
		</ul>
	</div>

		<c:forEach
			items="${listeInfosEncheres}"
			var="infos">
			<li class="list-group-item">Cras justo odio</li>
			<li class="list-group-item">Dapibus ac facilisis in</li>
			<li class="list-group-item">Vestibulum at eros</li>
		</c:forEach>
	<%@include file="FragmentFooter.jspf"%>


	

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>