<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet">
<title>Inscription</title>
</head>
<body>
	<header>
	<h1>ENI-Enchères</h1>
	</header>
	<div class="subheader">
		<form method="post" action="/trocenchere/ServletTestInscription">
				<div class="formulaire">
					<label for="pseudo">Pseudo :</label>
					<input type="text" name="pseudo" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required value="<%=request.getParameter("pseudo")%>"/><br>
					<label for="email">Email :</label>
					<input type="text" name="email" required value="<%=request.getParameter("email")%>"/><br>		
				</div>
				<div class="formulaire">
					<label for="nom">Nom :</label>
					<input type="text" name="nom" pattern="[A-Za-zÀ-ÖØ-öø-ÿ '-]{1,30}" required value="<%=request.getParameter("nom")%>"/><br>
					<label for="prenom">Prénom :</label>
					<input type="text" name="prenom" pattern="[A-Za-zÀ-ÖØ-öø-ÿ '-]{1,30}" required value="<%=request.getParameter("prenom")%>"/><br>			
				</div>		
				<!-- Password (UpperCase, LowerCase, Number/SpecialChar and min 8 Chars) -->
				<!-- Abcd123456789 -->
				<div class="formulaire">
					<label for="telephone">Téléphone :</label>
					<input type="tel" name="telephone" pattern="^0[1-9][0-9]{8}$" required value="<%=request.getParameter("telephone")%>"/><br>
					<label for="rue">Rue :</label>
					<input type="text" name="rue" pattern="^[\w\d\s'’°-\/\.]{1,30}$" required value="<%=request.getParameter("rue")%>"/><br>
				</div>
				<div class="formulaire">		
					<label for="ville">Ville :</label>
					<input type="text" name="ville" pattern="[A-Za-zÀ-ÖØ-öø-ÿ '-]{1,50}" required value="<%=request.getParameter("ville")%>"/><br>
					<label for="codePostal">Code postal :</label>
					<input type="text" name="codePostal" pattern="((0[1-9])|([1-8][0-9])|(9[0-8]))[0-9]{3}" required value="<%=request.getParameter("codePostal")%>"/><br>		
				</div>
				<div class="formulaire">			
					<label for="motDePasse">Mot de passe :</label>
					<input type="password" name="motDePasse" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" 
					required value="<%=request.getParameter("motDePasse")%>"/><br>		
					<label for="confirmationMDP">Confirmation :</label>
					<input type="password" name="confirmationMDP" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" 
					required value="<%=request.getParameter("confirmationMDP")%>"/><br>
				</div>
			
		<a href="${pageContext.request.contextPath}/ServletTestInscription"> <input type="submit" value="Créer un compte" /></a>
			  </form>
		<a href="${pageContext.request.contextPath}/ServletRedirectionAccueil"><input type="submit" value="Annuler" name="creerCompte"></a>			
	</div>
</body>
</html>