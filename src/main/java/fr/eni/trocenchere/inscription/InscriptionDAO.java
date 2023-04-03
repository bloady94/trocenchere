package fr.eni.trocenchere.inscription;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface InscriptionDAO {

	public void insertUtilisateur(Utilisateur utilisateur) throws BusinessException; 


}
