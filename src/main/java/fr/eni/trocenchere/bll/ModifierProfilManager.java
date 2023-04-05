package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface ModifierProfilManager {

	public void UpdateUtilisateur(Utilisateur user, String nouveauMDP)
			throws BusinessException;
}
