package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface ProfilDAO {
	public Utilisateur selectUtilisateurByID(Integer noUtilisateur) throws BusinessException;
}
