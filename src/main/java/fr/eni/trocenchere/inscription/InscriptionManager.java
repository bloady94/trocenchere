package fr.eni.trocenchere.inscription;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public class InscriptionManager {

	public Utilisateur ajouterUtilisateur1(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur) throws BusinessException {
		BusinessException businessException = new BusinessException();
		
		// verifier la nullité des saisies
		this.verifierNullite(pseudo, businessException);
		this.verifierNullite(nom, businessException);
		this.verifierNullite(prenom, businessException);
		this.verifierNullite(email, businessException);
		this.verifierNullite(telephone, businessException);
		this.verifierNullite(rue, businessException);
		this.verifierNullite(codePostal, businessException);
		this.verifierNullite(ville, businessException);
		this.verifierNullite(motDePasse, businessException);
		
		
		if (businessException.hasErreurs()) {
			throw businessException;
		}
		
		//vérifier la conformité des saisies (par rapport à un modèle ou à une taille maxi)
		this.verifierFormatEmail(motDePasse, businessException);
		this.verifierFormatEmail(email, businessException);
		this.verifierFormatEmail(telephone, businessException);
		
		this.verifierTailleChamps(pseudo, 30, businessException);
		this.verifierTailleChamps(nom, 30, businessException);
		this.verifierTailleChamps(prenom, 30, businessException);
		this.verifierTailleChamps(rue, 30, businessException);
		this.verifierTailleChamps(ville, 30, businessException);
		this.verifierTailleChamps(email, 100, businessException);
		this.verifierTailleChamps(codePostal, 10, businessException);
		
		if (businessException.hasErreurs()) {
				throw businessException;
		}

		
		
		this.verifierUnicitePseudo(pseudo, businessException);
		this.verifierFormatEmail(email, businessException);
		if (businessException.hasErreurs()) {
			throw businessException;
		}

		Utilisateur utilisateur =new Utilisateur();
		inscriptionDAO.insert(utilisateur);
		utilisateur.setCredit(100);
		utilisateur.setAdministrateur(false);
	
		return utilisateur;
	}

	private void verifierUnicitePseudo(String pseudo, BusinessException businessException) {
		// TODO Auto-generated method stub
		
	}

	private void verifierTailleChamps(String pseudo, int  i, BusinessException businessException) {
		int longueur = pseudo.length();
	    return;
		
	}

	private void verifierFormatEmail(String email, BusinessException businessException) {
		 Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
		    Matcher matcher = pattern.matcher(email);
		    return;
		
	}

	private void verifierConformiteMotDePasse(String motDePasse, BusinessException businessException) {
		// TODO Auto-generated method stub
		
	}

	private boolean verifierNullite(String pseudo, BusinessException businessException) {
		 return pseudo == null || pseudo.isEmpty();
		
	}



	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, String motDePasseConfirmation) {
		// TODO Auto-generated method stub
		return null;
	}

	public static InscriptionManager getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
