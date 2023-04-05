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
	<div class="subheader">
		<form action="<%=request.getContextPath()%>/ServletModifierProfil"
			method="get">
			<table>
				<tbody>
					<%
					Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
					Boolean connected = false;
					if (utilisateur != null){
					%>
					<tr>
						<td>Pseudo :
						<td>
						<td><%=utilisateur.getPseudo()%></td>
					</tr>
					<tr>
						<td>Nom :
						<td>
						<td><%=utilisateur.getNom()%></td>
					</tr>
					<tr>
						<td>Prénom :
						<td>
						<td><%=utilisateur.getPrenom()%></td>
					</tr>
					<tr>
						<td>Email :
						<td>
						<td><%=utilisateur.getEmail()%></td>
					</tr>
					<tr>
						<td>Téléphone :
						<td>
						<td><%=utilisateur.getTelephone()%></td>
					</tr>
					<tr>
						<td>Rue :
						<td>
						<td><%=utilisateur.getRue()%></td>
					</tr>
					<tr>
						<td>Code Postal :
						<td>
						<td><%=utilisateur.getCodePostal()%></td>
					</tr>
					<tr>
						<td>Ville :
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
			<input type="submit" value="Modifier">
		</form>
	</div>
</body>
</html>