package fr.eni.trocenchere.connexion;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface ConnexionDAO {
	
	//public Utilisateur verificationPseudo(String pseudo, String motDePasse) throws BusinessException;
	
	
	//public Utilisateur verificationEmail(String email, String motDePasse) throws BusinessException;
	
	public Utilisateur selectPseudoEmailMDP(String pseudoOuEmail, String motDePasse) throws BusinessException;
}