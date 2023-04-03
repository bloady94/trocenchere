package fr.eni.trocenchere.modifierProfil;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public class ModifierProfilManager {

	private ModifierProfilDAO modifierProfilAO;

	public ModifierProfilManager() {
		this.modifierProfilAO = new ModifierProfilDAOJdbcImpl();
	}
	
	public Utilisateur UpdateUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse)
			throws BusinessException {

		BusinessException businessException = new BusinessException();
		
		Utilisateur utilisateurTemp = null;
		
		// Permet de vérifier tous les champs qui sont null
		this.verifNull(pseudo);
		this.verifNull(nom, "nom");
		this.verifNull(prenom, "prenom");
		this.verifNull(email, "email");
		this.verifNull(rue, "rue");
		this.verifNull(codePostal, "codePostal");
		this.verifNull(ville, "ville");
		this.verifNull(motDePasse, "motDePasse");

		return utilisateurTemp;	
	}
	

	private void verifNull(String pseudo) {
		// TODO Auto-generated method stub
		
	}
	
}
