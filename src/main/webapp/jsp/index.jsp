<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="fr.eni.trocenchere.bo.Utilisateur"%>
<%@page import="fr.eni.trocenchere.bo.ArticleVendu"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>

<body>
	<header>
		<h1>ENI - Enchères</h1>
		<%
		Boolean connected = false;
		if (session.getAttribute("utilisateur") != null)
			connected = ((Utilisateur) session.getAttribute("utilisateur")) != null;
		if (connected == false) {
		%>

		<a href="http://localhost:8080/trocenchere/jsp/connexion.jsp">S'inscrire
			- Se connecter</a>
		<%
		} else {
		%>
		<a href="#">Encheres</a> <a href="#">Vendre un article</a> <a
			href="${pageContext.request.contextPath}/ServletProfil">MonProfil</a>
		<a href="${pageContext.request.contextPath}/ServletDeconnexion">Deconnexion</a>
		<%
		}
		%>
	</header>
	<div class="subheader">
		<h2>Liste des enchères</h2>
		<form method="post" action="./ServletFiltre">
			<label for="filtres">Filtres : </label> <input type="search"
				value="Le nom de l'article contient"> <label for="categorie">Catégorie
				: </label> <select>
				<option>Informatique</option>
				<option>Ameublement</option>
				<option>Vêtement</option>
				<option>Sport et Loisirs</option>
			</select> <input type="submit" value="Rechercher">
		</form>
	</div>

	<div class="listeArticles">
		<%
		List<ArticleVendu> listeArticles = new ArrayList<>();
		listeArticles = (List<ArticleVendu>) request.getAttribute("listeArticles");
		if (listeArticles != null && listeArticles.size() > 0) {
			for (ArticleVendu articleVendu : listeArticles) {
		%>
		<p><%=articleVendu.getNomArticle()%></p>
		<%
		}
		} else {
		%>
		<p>Il n'y a pas d'articles à afficher</p>
		<%
		}
		%>
	</div>

</body>
</html>