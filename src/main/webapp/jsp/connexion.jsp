<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ENI-Enchères</h1>

	<div>
		<form method="get" action="./ServletConnexion">
	
			<div>
			<label for="identifiant">Identifiant :</label>
				<input type="text" name="identifiant" /><br>
			
			 <label for="MotDePasse">Mot de passe :</label>
			 	<input type="text" name="MotDePasse" /> <br>
			
			</div>
			
			<div>
			 	<input type="submit" value="Connexion" />
			 <input type="checkbox" name="SeSouvenir" value="SeSouvenirDeMoi">
	    		<label for="souvenirDeMoi">Se souvenir de moi</label>
	    		<a href="#"> Mot de passe oublié </a>
			
			</div>
		 	
		</form>
	
		
		<a href="#"> <input type="submit" value="Créer un compte" /></a>
	</div>
	
	
</body>
</html>