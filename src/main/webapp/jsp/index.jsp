<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Encheres-ENI</title>
</head>
<body>
<header>
<h1>ENI - Enchères</h1>
<a href="#">S'inscrire - Se connecter</a>
</header>
<div class="subheader">
<h2>Liste des enchères</h2>
<form method="post" action="./ServletFiltre">
<label for="filtres">Filtres : </label>
<input type="search" value="Le nom de l'article contient">
<label for="categorie">Catégorie : </label>
<select>
<option>Informatique</option>
<option>Ameublement</option>
<option>Vêtement</option>
<option>Sport et Loisirs</option>
</select>
<input type="submit" value="Rechercher">
</form>
</div>

</body>
</html>