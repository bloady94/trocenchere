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
<h1>ENI-Enchères</h1>

		<c:if test="${!empty errorMessage}">
			<div class="alert alert-danger" role="alert">
			  <strong>Erreur!</strong>
			  <ul>
			  	${errorMessage}
			  </ul>
			</div>
		</c:if>
		
		
	<div>
		<form method="post" action="/trocenchere/ServletConnexion">
	
			<div>
			<label for="identifiant">Identifiant :</label>
				<input type="text" name="identifiant" /><br>
			
			 <label for="MotDePasse">Mot de passe :</label>
			 	<input type="password" name="MotDePasse" /> <br>
			
			</div>
			
			<div>
			<a href="/ServletConnexion"><input type="submit" value="Connexion" /></a>
			 <input type="checkbox" name="SeSouvenir" value="SeSouvenirDeMoi">
	    		<label for="souvenirDeMoi">Se souvenir de moi</label>
	    		<a href="#"> Mot de passe oublié </a>
			
			</div>
		 	
		</form>
	
		
		<a href="http://localhost:8080/trocenchere/jsp/inscription.jsp"> <input type="submit" value="Créer un compte" /></a>
	</div>
	
	
</body>
</html>