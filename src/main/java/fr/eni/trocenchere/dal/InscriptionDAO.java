package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface InscriptionDAO {

	public void insertUtilisateur(Utilisateur utilisateur) throws BusinessException; 


}
