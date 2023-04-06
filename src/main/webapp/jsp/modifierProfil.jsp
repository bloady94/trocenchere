<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet">
<title>Insert title here</title>
</head>
	<header>
	<h1>ENI-Enchères</h1>
	</header>

	
	<div class="subheader">
		<form method="post" action="${pageContext.request.contextPath}/ServletModifierProfil">
			<div class="ligneArticle">
				<label for="pseudo" class="titre">Pseudo :</label>
					<input type="text" name="pseudo" value="${utilisateur.pseudo}" class="center"/><br>
			</div>
			<div class="ligneArticle">		
				<label for="prenom" class="titre">Prénom :</label>
					<input type="text" name="prenom" value="${utilisateur.prenom}" class="center"/><br>
			</div>
			<div class="ligneArticle">			
				<label for="telephone" class="titre">Téléphone :</label>
					<input type="text" name="telephone" value="${utilisateur.telephone}" class="center"/><br>
			</div>
			<div class="ligneArticle">			
				<label for="codePostal" class="titre">Code postal :</label>
					<input type="text" name="codePostal" value="${utilisateur.codePostal}" class="center"/><br>
			</div>	
			<div class="ligneArticle">			
				<label for="motDePasseActuel" class="titre">Mot de passe actuel :</label>
					<input type="password" name="motDePasseActuel" value="${utilisateur.motDePasse}" class="center"/><br>
			</div>
			<div class="ligneArticle">	
				<label for="nouveauMDP" class="titre">Nouveau mot de passe :</label>
					<input type="password" name="nouveauMDP" class="center"/><br>
			</div>
			<div class="ligneArticle">
				<label for="nom" class="titre">Nom :</label>
					<input type="text" name="nom" value="${utilisateur.nom}" class="center"/><br>
			</div>	
			<div class="ligneArticle">			
				<label for="email" class="titre">Email :</label>
					<input type="text" name="email" value="${utilisateur.email}" class="center"/><br>
			</div>		
			<div class="ligneArticle">		
				<label for="rue" class="titre">Rue :</label>
					<input type="text" name="rue" value="${utilisateur.rue}" class="center"/><br>
			</div>		
			<div class="ligneArticle">		
				<label for="ville" class="titre">Ville :</label>
					<input type="text" name="ville" value="${utilisateur.ville}" class="center"/><br>
			</div>		
			<div class="ligneArticle">		
				<label for="confirmationMDP" class="titre">Confirmation :</label>
					<input type="password" name="confirmationMDP" value="" class="center"/><br>
			</div>
			<div class="ligneArticle">
			<label for="credit" class="titre">Crédit :</label><p class="center">100</p>
			<!-- Ajouter Crédit avec le nom de crédit -->
			</div>
			<input type="submit" value="Enregistrer" class="modifierProfil"/>
			
		</form>
		
		<a href="${pageContext.request.contextPath}/ServletDeconnexion"> <input type="submit" value="Supprimer mon compte" class="modifierProfil"/></a>
	</div>
</body>
</html>