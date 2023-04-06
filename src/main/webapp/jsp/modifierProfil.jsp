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
				<label for="pseudo">Pseudo :</label>
					<input type="text" name="pseudo" value="${utilisateur.pseudo}" class="center"/><br>
			</div>
			<div class="ligneArticle">		
				<label for="prenom">Prénom :</label>
					<input type="text" name="prenom" value="${utilisateur.prenom}" class="center"/><br>
			</div>
			<div class="ligneArticle">			
				<label for="telephone">Téléphone :</label>
					<input type="text" name="telephone" value="${utilisateur.telephone}" class="center"/><br>
			</div>
			<div class="ligneArticle">			
				<label for="codePostal">Code postal :</label>
					<input type="text" name="codePostal" value="${utilisateur.codePostal}" class="center"/><br>
			</div>	
			<div class="ligneArticle">			
				<label for="motDePasseActuel">Mot de passe actuel :</label>
					<input type="password" name="motDePasseActuel" value="${utilisateur.motDePasse}" class="center"/><br>
			</div>
			<div class="ligneArticle">	
				<label for="nouveauMDP">Nouveau mot de passe :</label>
					<input type="password" name="nouveauMDP" class="center"/><br>
			</div>
			<div class="ligneArticle">
				<label for="nom">Nom :</label>
					<input type="text" name="nom" value="${utilisateur.nom}" class="center"/><br>
			</div>	
			<div class="ligneArticle">			
				<label for="email">Email :</label>
					<input type="text" name="email" value="${utilisateur.email}" class="center"/><br>
			</div>		
			<div class="ligneArticle">		
				<label for="rue">Rue :</label>
					<input type="text" name="rue" value="${utilisateur.rue}" class="center"/><br>
			</div>		
			<div class="ligneArticle">		
				<label for="ville">Ville :</label>
					<input type="text" name="ville" value="${utilisateur.ville}" class="center"/><br>
			</div>		
			<div class="ligneArticle">		
				<label for="confirmationMDP">Confirmation :</label>
					<input type="password" name="confirmationMDP" value="" class="center"/><br>
			</div>
			<div class="ligneArticle">
			<label for="credit">Crédit :</label><p class="center"><%= request.getAttribute("credit") %></p>
			<!-- Ajouter Crédit avec le nom de crédit -->
			</div>
			<input type="submit" value="Enregistrer" class="modifierProfil"/>
			
		</form>
		
		<a href="${pageContext.request.contextPath}/ServletDeconnexion"> <input type="submit" value="Supprimer mon compte" class="modifierProfil"/></a>
	</div>
</body>
</html>