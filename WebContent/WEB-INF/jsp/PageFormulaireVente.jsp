<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap + CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/AccueilStyle.css" />

<title>Nouvelle vente</title>
</head>
<body>
	<div class="container">
		<header>
			<div class="row">
				<div class="col-6">
					<a href="${pageContext.request.contextPath}"> <img alt="LOGO"
						src="<%=request.getContextPath()%>/resources/logoLOSNA.png">
					</a>
				</div>
				<div class="col-1,5">
					<button class="btn btn-primary mt-5 mr-2" type="submit">Enchères</button>
				</div>
				<div class="col-1,5">
					<form
						method="GET"
						action="<%=request.getContextPath()%>/MiseEnVente">
					<button class="btn btn-primary mt-5 mr-2" type="submit">Vendre</button>
					</form>
				</div>
				<div class="col-1,5">

					<button class="btn btn-primary mt-5 mr-2" type="submit">Mon
						profil</button>
				</div>
				<div class="col-1,5">

					<button class="btn btn-primary mt-5" type="submit">Déconnexion</button>
				</div>
			</div>

		</header>
	</div>

	<h1>Formulaire de vente des articles</h1>
	
	

</body>
</html>