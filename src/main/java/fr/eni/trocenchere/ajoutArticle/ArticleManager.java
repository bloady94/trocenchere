package fr.eni.trocenchere.ajoutArticle;

import java.time.LocalDate;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Utilisateur;


public class ArticleManager {
	
	private AjoutArticleDAO ajoutasrticleDAO;
	
	
	


	private ArticleVendu ajoutArticle (  String nomArticle, String description, LocalDate debutEnchere, LocalDate finEnchere,
			Integer prixInitial, Integer prixVente, Utilisateur utilisateur, Categorie categorie) throws BusinessException {
		
		        BusinessException businessException = new BusinessException();
		       
		        ArticleVendu ajoutarticle = new ArticleVendu();
		        ajoutarticle.setNomArticle(nomArticle);
		        ajoutarticle.setDescription(description);
		        ajoutarticle.setDebutEnchere(debutEnchere);
		        ajoutarticle.setFinEnchere(finEnchere);
		        ajoutarticle.setPrixInitial(prixInitial);
		        ajoutarticle.setPrixFinal(prixVente);
		        ajoutarticle.setUtilisateur(utilisateur);
		        ajoutarticle.setCategorie(categorie);
		      
		       
		        if(!businessException.hasErreurs ()) 
				{
		        	this.ajoutasrticleDAO.ajoutarticle(ajoutarticle);
					
				}else 
				{
					throw businessException;
				}
				
				return ajoutarticle ;
		    }
		
	

}
