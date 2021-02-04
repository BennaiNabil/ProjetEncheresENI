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

	<%
		boolean isSubscribing = true;
		boolean isPageAnonyme = false;
	%>
	<%@include file="FragmentHeader.jspf"%>

	<p>${utilisateur.toString() }</p>


<%@include file="FragmentFooter.jspf" %>
</body>
</html>