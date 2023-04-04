package fr.eni.trocenchere.dal;

import java.util.List;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;

public interface ArticleDAO {

	public void ajoutarticle(ArticleVendu articleVendu) throws BusinessException;
	public List<ArticleVendu> selectArticles() throws BusinessException;
}
