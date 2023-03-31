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
		<form method="get" action="./ServletTestInscription">
			<div>
				<label for="pseudo">Pseudo :</label>
					<input type="text" name="pseudo" /><br>
							
				<label for="prenom">Prénom :</label>
					<input type="text" name="prenom" /><br>
							
				<label for="telephone">Téléphone :</label>
					<input type="tel" name="telephone" /><br>
							
				<label for="codePostal">Code postal :</label>
					<input type="text" name="codePostal" /><br>
							
				<label for="motDePasse">Mot de passe :</label>
					<input type="password" name="motDePasse" /><br>
			</div>
			
			
			<div>
				<label for="nom">Nom :</label>
					<input type="text" name="nom" /><br>
							
				<label for="email">Email :</label>
					<input type="text" name="email" /><br>
							
				<label for="rue">Rue :</label>
					<input type="text" name="rue" /><br>
							
				<label for="ville">Ville :</label>
					<input type="text" name="ville" /><br>
							
				<label for="conformationMDP">Confirmation :</label>
					<input type="password" name="confirmationMDP" /><br>
			</div>
			
			 <form method="post" action="./inscription.jsp">
			<input type="submit" value="Créer" />
			  </form>
			
			
		</form>
		
		 <form method="post" action="./inscription.jsp">
		<a href="#"> <input type="submit" value="Créer un compte" /></a>
			  </form>
			
			
	</div>
	
	

</body>
</html>