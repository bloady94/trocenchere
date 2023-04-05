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

		<form method="post" action="/trocenchere/ServletConnexion">
	
			<div class="subheader">
			<label for="identifiant">Identifiant :</label>
				<input type="text" name="identifiant" /><br>
			
			 <label for="MotDePasse">Mot de passe :</label>
			 	<input type="password" name="MotDePasse" /> <br>
			

			<a href="/ServletConnexion"><input type="submit" value="Connexion" /></a>
			<div class="seSouvenirDeMoi">
			 <input type="checkbox" name="SeSouvenir" value="SeSouvenirDeMoi">
			 
	    		<label for="souvenirDeMoi">Se souvenir de moi</label>
	    		</div>
	    		<a href="#"> Mot de passe oublié </a>
			

			</div>
		 	
		</form>
			<a href="${pageContext.request.contextPath}/ServletRedirectionInscription"> <input type="submit" value="Créer un compte" /></a>
		

	
	
</body>
</html>