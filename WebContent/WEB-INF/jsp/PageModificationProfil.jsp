<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification de mon profil</title>
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

	<%
		boolean isPageAnonyme = false;
	%>
	<%@include file="FragmentHeader.jspf"%>

	<p>${utilisateur.toString() }</p>
</body>
</html>