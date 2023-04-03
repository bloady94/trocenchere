package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.InscriptionDAO;
import fr.eni.trocenchere.inscription.DAOFactory;

public class ModifierProfilManager implements ModifierProfil{

	private ModifierProfil modifierProfil;

//	public ModifierProfilManager() {
//		this.modifierProfil = DAOFactory.getModifierProfilDAO();
//	}
	
	@Override
	public Utilisateur UpdateUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) throws BusinessException {
		
		// il faut creer un utilisateur
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue,codePostal, ville, motDePasse);
		
		if (!pseudo.isEmpty()) {
			user.setPseudo(pseudo);
		}
		
		if (!nom.isEmpty()) {
			user.setPseudo(nom);
		}
		
		if (!prenom.isEmpty()) {
			user.setPseudo(prenom);
		}
		
		if (!email.isEmpty()) {
			user.setPseudo(email);
		}
		
		if (!telephone.isEmpty()) {
			user.setPseudo(telephone);
		}
		
		if (!rue.isEmpty()) {
			user.setPseudo(rue);
		}
		
		if (!codePostal.isEmpty()) {
			user.setPseudo(codePostal);
		}
		
		if (!codePostal.isEmpty()) {
			user.setPseudo(codePostal);
		}
		
		if (!ville.isEmpty()) {
			user.setPseudo(ville);
		}
		
		if (!motDePasse.isEmpty()) {
			user.setPseudo(motDePasse);
		}
		
		return user;
	}

}
