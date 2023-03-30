package fr.eni.trocenchere.connexion;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface ConnexionDAO {
	
	public Utilisateur select_connexionPseudo(String pseudo, String motDePasse) throws BusinessException;
	
	public Utilisateur select_connexionEmail(String email, String motDePasse) throws BusinessException;

	public static boolean VerificationPseudo(String pseudo, String motDePasse) throws BusinessException {
		return false;
	}
}
