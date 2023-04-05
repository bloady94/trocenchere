package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface ProfilDAO {
	
	public Utilisateur selectUtilisateurByNo(Integer noUtilisateur) throws BusinessException;
	
	public Utilisateur selectUtilisateurByMDP(String mdpUtilisateur) throws BusinessException;
	
	
}
