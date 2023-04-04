package fr.eni.trocenchere.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DAOFactory;
import fr.eni.trocenchere.dal.ModifierProfilDAO;

public class ModifierProfilManager implements ModifierProfil {
	
	private ModifierProfilDAO modifierProfilDAO;

	public ModifierProfilManager() {
		this.modifierProfilDAO = DAOFactory.getModifierProfilDAO();
	}

	@Override
	public Utilisateur UpdateUtilisateur(Utilisateur user, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostal, String ville, String motDePasse) throws BusinessException {

		BusinessException businessException = new BusinessException();
		
		this.validerPseudo(pseudo, businessException);
		this.validerEmail(email, businessException);
		this.validerCoordonnees(pseudo,nom, prenom, telephone, rue, codePostal, ville, motDePasse);
		
		
		return null;
	}

	
	private void validerCoordonnees(String pseudo, String nom, String prenom, String telephone, String rue, String codePostal,
			String ville, String motDePasse) {

		if(pseudo)
		
	}

	private void validerEmail(String email, BusinessException businessException) {
		
		if (email == null || email.isBlank() || email.isEmpty()) {
			
			// On ajouter l'erreur et on précise ce qu'elle renvoie
			businessException.ajouterErreur("L'email ne peut pas être vide");
		}
		
	    if (!emailCorrect(email)) {
	        businessException.ajouterErreur("L'email n'est pas valide");
	        return;
	    }
		
	}

	private boolean emailCorrect(String email) {
		
		// Cela permet de savoir ce que doit contenir l'email
	    String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	    
	    // On insère le regex dans un pattern
	    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    
	    // Grace à l'objet Matcher, on vérifie si que l'email correspond bien au pattern demandé.
	    Matcher matcher = pattern.matcher(email);
	    
	    return matcher.matches();
	
	}

	private void validerPseudo(String pseudo, BusinessException businessException) {
		
		if (pseudo == null || pseudo.trim().isEmpty()) {
			
			// On ajouter l'erreur et on précise ce qu'elle renvoie
			businessException.ajouterErreur("Le pseudo n'est pas correct");
		}
		
	}




}
