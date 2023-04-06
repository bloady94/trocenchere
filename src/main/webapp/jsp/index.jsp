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
<link href="css/styles.css" rel="stylesheet">
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

		<a
			href="${pageContext.request.contextPath}/ServletRedirectionConnexion">S'inscrire
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
			</select> 
			<input type="submit" value="Rechercher" class="rechercher">
		</form>
	</div>

	<div class="listeArticles">
		<%
		List<ArticleVendu> listeArticles = new ArrayList<>();
		listeArticles = (List<ArticleVendu>) request.getAttribute("listeArticles");
		if (listeArticles != null && listeArticles.size() > 0) {
			for (ArticleVendu articleVendu : listeArticles) {
		%>
		<div class="article">
			<div class="ligneArticle">
				<h3>Nom de l'article</h3>
				<p><%=articleVendu.getNomArticle()%></p>
			</div>
			<!-- 			<div class="ligneArticle"> -->
			<!-- 				<h4>Description</h4> -->
			<%-- 				<p><%=articleVendu.getDescription()%></p> --%>
			<!-- 			</div> -->
			<!-- 			<div class="ligneArticle"> -->
			<!-- 				<h4>Proposé à l'enchère le</h4> -->
			<%-- 				<p><%=articleVendu.getDebutEnchere()%></p> --%>
			<!-- 			</div> -->
			<div class="ligneArticle">
				<h3>Fin de l'enchère prévue le</h3>
				<p><%=articleVendu.getFinEnchere()%></p>
			</div>
			<!-- 			<div class="ligneArticle"> -->
			<!-- 				<h4>Mise à prix</h4> -->
			<%-- 				<p><%=articleVendu.getPrixInitial()%></p> --%>
			<!-- 			</div> -->
			<div class="ligneArticle">
				<h3>Enchère actuelle</h3>
				<p><%=articleVendu.getPrixFinal()%></p>
			</div>
			<div class="ligneArticle">
				<h3>Vendeur</h3>
				<p><%=articleVendu.getUtilisateur().getPseudo()%></p>
			</div>
			<div class="ligneArticle">
				<h3>Catégorie</h3>
				<p><%=articleVendu.getCategorie().getLibelle()%></p>
			</div>
		</div>
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