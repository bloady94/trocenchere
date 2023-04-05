<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/ServletAjoutArticle" method="post">

<action="ajout-article" method="post">
 <label for="nouvelle vente">Nouvelle Vente</label><br>
 <br>

    <label for="article">Article :</label>
    <input type="text" name="article" id="article"><br>

    <label for="description">Description :</label>
    <textarea name="description" id="description"></textarea><br>
    
    

    <label for="categorie">Categorie :</label>
	<select name="categorie">
	<option value=""></option>
  <option value="jouet">Jouet</option>
  <option value="auto">Auto</option>
  <option value="electromenager">Electromenager</option>
  <option value="jardin">Jardin</option>
    </select>
   <br>
    
    
   
  <label for="article">Photo de l'Article :</label>
	<img src="chemin/vers/mon/image.jpg"><br>
	
	<label for="prix">Mise à Prix :</label>
	<input type="number" name="prix" id="prix"><br>
	
	  <label for="article">Debut de l'Enchere :</label>
	    <input type="date" name="debut de l'enchere" id="debut de l'enchere"><br>
	    
	    <label for="article">Fin de l'Enchere :</label>
	    <input type="date" name="fin de l'enchere" id="fin de l'enchere"><br>
	    
	     <label for="retrait">RETRAIT</label><br>
	     
	  
	    
    <label for="rue">Rue :</label>
    <input type="text" name="rue" id="rue"><br>
    
    <label for="codePostal">Code Postal :</label>
    <input type="text" name="codePostal" id="codePostal"><br>
    
    <label for="ville">Ville :</label>
    <input type="text" name="ville" id="ville"><br>
    
   
	<p style="color: green;">L'article a été ajo

    <input type="submit" value="Enregistrer">
    <input type="submit" value="Annuler">
   
    
    
</form>

</body>
</html>