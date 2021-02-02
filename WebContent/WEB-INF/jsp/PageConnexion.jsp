<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AccueilStyle.css"/>
<meta charset="UTF-8">
<title>Connexion</title>

<!-- Script JAVASCRIPT -->
<!-- Script d'intégration de JQuery pour les méthodes d'affichage des modales -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> 

<!-- Script d'affichage de la fenetre modale au chargement de la page -->
<script>
    	$(document).ready(function(){
        $("#fenetreModale").modal('show'); 							
    });
</script>

</head>
<body>
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
					<p>Saisissez vos identifiants de connexion</p>                  
               </div>
               <!-- **** -->
               <!-- body -->
               <!-- **** -->
               <div class="modal-body">
                  	<form method="POST" action="<%= request.getContextPath() %>/Connexion">
					<!--  Champs de saisie de l'identifiant utilisateur -->
					<div class="row">
						<label class="col-4" for="identifiant">Identifiant :</label>
						<input class="col-6" type="text" name="identifiant" id="identifiant" autofocus="autofocus" required="required"/>
					</div>
					<div class="row">
						<!--  Champs de saisie du mdp utilisateur -->	
						<label class="col-4" for="mdp">Mot de passe :</label>
						<input class="col-6" type="password" name="mdp" id="mdp" required="required"/>
					</div>
               </div>
               <!-- ****** -->
               <!-- footer -->
               <!-- ****** -->
               <div class="modal-footer">
               	  <!-- Bouton de fermeture de la modale sans prise en compte des saisies -->
                  <button type="button" class="btn btn-primary" data-dismiss="modal">Retour</button>
                  <!-- Bouton de vaidation des infos saisie dans la modale -->
                  <button type="submit" class="btn btn-primary" value="Connexion">Connexion</button>
                  </form>
               </div>
            </div>
         </div>
      </div>
      
	<!-- Intégration de bootstrap javascript -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>