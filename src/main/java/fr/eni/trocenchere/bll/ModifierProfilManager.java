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
			String telephone, String rue, String codePostal, String ville, String mdpActuel, String nouveauMDP) throws BusinessException {

		BusinessException businessException = new BusinessException();

		this.validerPseudo(pseudo, businessException);
		this.validerEmail(email, businessException);
		this.validerCoordonnees(pseudo, nom, prenom, telephone, rue, codePostal, ville, businessException); 
		this.validerMDP(user.getMotDePasse(),nouveauMDP, businessException);
		
		if(!businessException.hasErreurs()) { 
			
			modifierProfilDAO.update_utilisateur(user);

			} else { 
				
			throw businessException; 
			}

		return user;	

	}

	private void validerMDP(String motDePasse, String nouveauMDP, BusinessException businessException) {
		
		if(motDePasse.equals(nouveauMDP)) {
			businessException.ajouterErreur("Le nouveau mot de passe ne doit pas être identique au mot de passe actuel.");
		}
	}
	

	private void validerCoordonnees(String pseudo, String nom, String prenom, String telephone, String rue,
			String codePostal, String ville, BusinessException businessException) {

		if (pseudo == null || pseudo.isBlank() || pseudo.isEmpty()) {
			businessException.ajouterErreur("Le pseudo ne peut pas être vide");
		}

		if (nom == null || nom.isBlank() || nom.isEmpty()) {
			businessException.ajouterErreur("Le nom ne peut pas être vide");
		}

		if (prenom == null || prenom.isBlank() || prenom.isEmpty()) {
			businessException.ajouterErreur("Le prénom ne peut pas être vide");
		}

		if (!telephoneEstCorrect(telephone)) {
			businessException.ajouterErreur("Le téléphone n'est pas valide");
		}

		if (rue == null || rue.isBlank() || rue.isEmpty()) {
			businessException.ajouterErreur("La rue ne peut pas être vide");
		}

		if (!CodePostalCorrect(codePostal)) {
			businessException.ajouterErreur("Le téléphone n'est pas valide");
		}
		
		if (ville == null || ville.isBlank() || ville.isEmpty()) {
			businessException.ajouterErreur("La ville ne peut pas être vide");
		}
		

	}

	private boolean CodePostalCorrect(String codePostal) {
		
	    String regex = "^(97|98)\\d{3}$|^\\d{5}$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(codePostal);
	    
	    return matcher.matches();
	}

	private boolean telephoneEstCorrect(String telephone) {

		String regex = "^(\\+33|0)[1-9](\\d{2}){4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(telephone);

		return matcher.matches();
	}

	private void validerEmail(String email, BusinessException businessException) {

		if (email == null || email.isBlank() || email.isEmpty()) {

			// On ajouter l'erreur et on précise ce qu'elle renvoie
			businessException.ajouterErreur("L'email ne peut pas être vide");
		}

		if (!emailEstCorrect(email)) {
			businessException.ajouterErreur("L'email n'est pas valide");
			return;
		}

	}

	private boolean emailEstCorrect(String email) {

		// Cela permet de savoir ce que doit contenir l'email
		String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

		// On insère le regex dans un pattern
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		// Grace à l'objet Matcher, on vérifie si que l'email correspond bien au pattern
		// demandé.
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
