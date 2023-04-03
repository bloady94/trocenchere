package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;

public interface AjoutArticleDAO {

	public void ajoutarticle(ArticleVendu articleVendu) throws BusinessException;
	
}
