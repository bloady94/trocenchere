package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

import fr.eni.trocenchere.dal.DAOFactory;
import fr.eni.trocenchere.dal.ProfilDAO;


public interface ProfilManager {
	
	public Utilisateur selectUtilisateurByNo(Integer noUtilisateur) throws BusinessException;
	
	public Utilisateur selectUtilisateurByMDP(String mdpUtilisateur) throws BusinessException;
}
