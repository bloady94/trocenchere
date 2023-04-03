<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<h1>ENI-Enchères</h1>
	
	<div>
		<form method="post" action="./Mettre le nom de la servlet">
			<div>
				<label for="pseudo">Pseudo :</label>
					<input type="text" name="pseudo" /><br>
							
				<label for="prenom">Prénom :</label>
					<input type="text" name="prenom" /><br>
							
				<label for="telephone">Téléphone :</label>
					<input type="text" name="telephone" /><br>
							
				<label for="codePostal">Code postal :</label>
					<input type="text" name="codePostal" /><br>
							
				<label for="motDePasseActuel">Mot de passe actuel :</label>
					<input type="password" name="motDePasseActuel" /><br>
				
				<label for="nouveauMDP">Nouveau mot de passe :</label>
					<input type="password" name="nouveauMDP" /><br>
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
							
				<label for="confirmationMDP">Confirmation :</label>
					<input type="password" name="confirmationMDP" /><br>
			</div>
			
			
				<%
		Integer nbCredit = (Integer) request.getAttribute("credit");
	%>
	
	Crédit :<%=nbCredit %>
			<!-- Ajouter Crédit avec le nom de crédit -->
			
			<input type="submit" value="Enregistrer" />
			
		</form>
		
		<a href="#"> <input type="submit" value="Supprimer mon compte" /></a>
			
	</div>
	
	

</body>
</html>