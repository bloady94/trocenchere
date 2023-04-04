package fr.eni.trocenchere.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.ArticleDAO;
import fr.eni.trocenchere.dal.DAOFactory;


public class ArticleManager {
	
	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	public ArticleVendu ajoutArticle(  String nomArticle, String description, LocalDate debutEnchere, LocalDate finEnchere,
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
		        	this.articleDAO.ajoutarticle(ajoutarticle);
					
				}else 
				{
					throw businessException;
				}
				
				return ajoutarticle ;
		    }
		
	
	public List<ArticleVendu> selectionnerTousLesArticles() throws BusinessException{
		return this.articleDAO.selectArticles();
	}

}
