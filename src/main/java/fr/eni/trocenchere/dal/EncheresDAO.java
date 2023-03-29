package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.bo.Retrait;
import fr.eni.trocenchere.bo.Utilisateur;

public interface EncheresDAO {
	
	public void insert_utilisateur(Utilisateur utilisateur) throws BusinessException;
	public void insert_articleVendu(ArticleVendu articleVendu) throws BusinessException;
	public void insert_enchere(Enchere enchere) throws BusinessException;
	public void insert_retrait(Retrait retrait) throws BusinessException;
	public void insert_categorie(Categorie categorie) throws BusinessException;
	
	
	public void delete_utilisateur(Utilisateur utilisateur) throws BusinessException;
	public void delete_articleVendu(ArticleVendu articleVendu) throws BusinessException;
	
	
	public void update_utilisateur(Utilisateur utilisateur) throws BusinessException;
	public void update_enchere(Enchere enchere) throws BusinessException;

	public void select_utilisateur(Utilisateur utilisateur) throws BusinessException;
	public void select_article(ArticleVendu articleVendu) throws BusinessException;

}
