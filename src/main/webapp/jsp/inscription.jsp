<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>

	<h1>ENI-Enchères</h1>
	
	<div>
		<form method="post" action="./ServletTestInscription">
			<div>
				<label for="pseudo">Pseudo :</label>
					<input type="text" name="pseudo" value="<%=request.getParameter("pseudo")%>"/><br>
							
				<label for="prenom">Prénom :</label>
					<input type="text" name="prenom" value="<%=request.getParameter("prenom")%>"/><br>
							
				<label for="telephone">Téléphone :</label>
					<input type="tel" name="telephone" value="<%=request.getParameter("telephone")%>"/><br>
							
				<label for="codePostal">Code postal :</label>
					<input type="text" name="codePostal" value="<%=request.getParameter("codePostal")%>"/><br>
							
				<label for="motDePasse">Mot de passe :</label>
					<input type="password" name="motDePasse" value="<%=request.getParameter("motDePasse")%>"/><br>
			</div>
			
			
			<div>
				<label for="nom">Nom :</label>
					<input type="text" name="nom" value="<%=request.getParameter("nom")%>"/><br>
							
				<label for="email">Email :</label>
					<input type="text" name="email" value="<%=request.getParameter("email")%>"/><br>
							
				<label for="rue">Rue :</label>
					<input type="text" name="rue" value="<%=request.getParameter("rue")%>"/><br>
							
				<label for="ville">Ville :</label>
					<input type="text" name="ville" value="<%=request.getParameter("ville")%>"/><br>
							
				<label for="confirmationMDP">Confirmation :</label>
					<input type="password" name="confirmationMDP" value="<%=request.getParameter("confirmationMDP")%>"/><br>
			</div>
			
		<a href="/trocenchere/inscription/ServletTestInscription"> <input type="submit" value="Créer un compte" /></a>
			  </form>
		<a href="http://localhost:8080/trocenchere/"><input type="submit" value="Annuler"></a>			
	</div>
</body>
</html>