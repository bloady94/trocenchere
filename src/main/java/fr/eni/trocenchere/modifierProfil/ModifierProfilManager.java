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

		/* 
		 * Donc la l'idée est de créer une variable utilisateurTemp de type utilisateur, on l'initialise à null
		 * car on lui donnera des valeurs pendant les verifs.
		 */
		Utilisateur utilisateurTemp = null;

		
		/* 
		 * Conditon if ou on demande si le champs pseudo n'est pas vide.
		 * S'il y a quelque chose dedans, on prend la valeur et boum on setPseudo avec.
		 * En revanche, S'il y r dedans on get le pseudo de base et boum.
		 */
		if(!pseudo.isEmpty()) {
			utilisateurTemp.setPseudo(pseudo);
		}
	
		
		if(!nom.isEmpty()) {
			utilisateurTemp.setPseudo(nom);
		}
		
		if(!prenom.isEmpty()) {
			utilisateurTemp.setPseudo(prenom);
		}
		
		if(!email.isEmpty()) {
			utilisateurTemp.setPseudo(email);
		}
		
		if(!telephone.isEmpty()) {
			utilisateurTemp.setPseudo(telephone);
		}
		
		if(!rue.isEmpty()) {
			utilisateurTemp.setPseudo(rue);
		}
		
		if(!codePostal.isEmpty()) {
			utilisateurTemp.setPseudo(codePostal);
		}
		
		if(!ville.isEmpty()) {
			utilisateurTemp.setPseudo(ville);
		}
		
		if(!motDePasse.isEmpty()) {
			utilisateurTemp.setPseudo(motDePasse);
		}


		
		return utilisateurTemp;	
	}
	
}
