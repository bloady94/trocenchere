package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Categorie;

public interface CategorieDAO {

	public Categorie selectById(Integer noCategorie) throws BusinessException;
}
