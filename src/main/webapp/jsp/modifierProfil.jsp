<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet">
<title>Insert title here</title>
</head>

	<h1>ENI-Enchères</h1>
	
	<div>
		<form method="post" action="${pageContext.request.contextPath}/ServletModifierProfil">
			<div>
				<label for="pseudo">Pseudo :</label>
					<input type="text" name="pseudo" />${utilisateur.pseudo}<br>
							
				<label for="prenom">Prénom :</label>
					<input type="text" name="prenom" />${utilisateur.prenom}<br>
							
				<label for="telephone">Téléphone :</label>
					<input type="text" name="telephone" />${utilisateur.telephone}<br>
							
				<label for="codePostal">Code postal :</label>
					<input type="text" name="codePostal" />${utilisateur.codePostal}<br>
							
				<label for="motDePasseActuel">Mot de passe actuel :</label>
					<input type="password" name="motDePasseActuel" />${utilisateur.pseudo}<br>
				
				<label for="nouveauMDP">Nouveau mot de passe :</label>
					<input type="password" name="nouveauMDP" />${utilisateur.pseudo}<br>
			</div>
			
			
			<div>
				<label for="nom">Nom :</label>
					<input type="text" name="nom" />${utilisateur.pseudo}<br>
							
				<label for="email">Email :</label>
					<input type="text" name="email" />${utilisateur.pseudo}<br>
							
				<label for="rue">Rue :</label>
					<input type="text" name="rue" />${utilisateur.pseudo}<br>
							
				<label for="ville">Ville :</label>
					<input type="text" name="ville" />${utilisateur.pseudo}<br>
							
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