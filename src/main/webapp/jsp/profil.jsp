<%@page import="fr.eni.trocenchere.bo.Utilisateur"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet">
<title>Mon Profil</title>
</head>
<body>
	<header>
		<h1>ENI - Enchères</h1>
	</header>
	<div class="profilBox">
		<form action="<%=request.getContextPath()%>/ServletModifierProfil"
			method="get">
			<table>
				<tbody>
					<%
					Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
					Boolean connected = false;
					if (utilisateur != null){
					%>
					<tr class="ligneArticle">
						<td class="titre">Pseudo :
						<td>
						<td class="aModifier"><%=utilisateur.getPseudo()%></td>
					</tr>
					<tr class="ligneArticle">
						<td class="titre">Nom :
						<td>
						<td><%=utilisateur.getNom()%></td>
					</tr>
					<tr class="ligneArticle">
						<td class="titre">Prénom :
						<td>
						<td><%=utilisateur.getPrenom()%></td>
					</tr >
					<tr class="ligneArticle">
						<td class="titre">Email :
						<td>
						<td><%=utilisateur.getEmail()%></td>
					</tr>
					<tr class="ligneArticle">
						<td class="titre">Téléphone :
						<td>
						<td><%=utilisateur.getTelephone()%></td>
					</tr>
					<tr class="ligneArticle">
						<td class="titre">Rue :
						<td>
						<td><%=utilisateur.getRue()%></td>
					</tr>
					<tr class="ligneArticle">
						<td class="titre">Code Postal :
						<td>
						<td><%=utilisateur.getCodePostal()%></td>
					</tr>
					<tr class="ligneArticle">
						<td class="titre">Ville :
						<td>
						<td><%=utilisateur.getVille()%></td>
					</tr>
					<%
					} else {
					%>
					<p>Pas d'informations à afficher</p>
					<%
					}
					%>
				</tbody>
			</table>
			<input type="submit" value="Modifier" class="modifierProfil">
		</form>
	</div>
</body>
</html>