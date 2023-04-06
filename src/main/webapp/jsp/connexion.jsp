<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet">
<title>Se connecter</title>
</head>

<body>
<header>
<h1>ENI-Enchères</h1>		
</header>	
			<div class="subheader">
		<form method="post" action="/trocenchere/ServletConnexion">
	
			<div class="ligneConnexion">
			<label for="identifiant">Identifiant :</label>
				<input type="text" name="identifiant" class="center"/><br>
			</div>
			<div class="ligneConnexion">
			 <label for="MotDePasse">Mot de passe :</label>
			 	<input type="password" name="MotDePasse" class="center"/> <br>
			</div>

			<a href="/ServletConnexion"><input type="submit" value="Connexion" class="modifierProfil"/></a>
			
			
		 	
		</form>
			<a href="${pageContext.request.contextPath}/ServletRedirectionInscription"> <input type="submit" value="Créer un compte" class="modifierProfil"/></a>
			<div class="seSouvenirDeMoi">
			<div class="checkboxEtLabel">
			 	<input type="checkbox" name="SeSouvenir" value="SeSouvenirDeMoi" class="checkbox">
	    	 	<label for="souvenirDeMoi">Se souvenir de moi</label>
			</div>
	    		<a href="#"> Mot de passe oublié </a>
	    	</div>
		
			</div>
	
	
</body>
</html>