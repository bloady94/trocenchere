package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface ProfilManager {
	public Utilisateur afficherProfil(Utilisateur utilisateur) throws BusinessException;
}
