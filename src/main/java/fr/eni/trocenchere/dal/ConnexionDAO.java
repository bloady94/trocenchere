package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface ConnexionDAO {
	
	public Utilisateur selectPseudoEmailMDP(String pseudoOuEmail, String motDePasse) throws BusinessException;
}