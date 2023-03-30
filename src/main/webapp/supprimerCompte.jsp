<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Suppression</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	
	<form method="get" action="./ServletSupprimerCompte">
	<div class="container">
		<h1 class="titre">Supprimer le profil</h1>
		
    <p class="info">Attention, cette action est irréversible</p>

    <form method="post" action="./supprimerCompte.jsp">
        <input type="submit" value="Confirmer"/>
    </form>

    <form method="post" action="./supprimerCompte.jsp">
        <input type="submit" value="Annuler" />
    </form>
    
    </div>

</body>
</html>