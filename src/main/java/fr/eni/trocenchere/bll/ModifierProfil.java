package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface ModifierProfil {

	public Utilisateur UpdateUtilisateur(Utilisateur user, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostal, String ville, String mdpActuel, String nouveauMDP)
			throws BusinessException;
}
