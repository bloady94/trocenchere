package fr.eni.trocenchere.inscription;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public class InscriptionManager {
	private inscriptionDAO inscriptionDao;

	public InscriptionManager() {
		this.inscriptionDao = DAOFactory.getInscriptionDAO();
	}

	public Utilisateur ajouterUtilisateur1(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur)
			throws BusinessException {
		BusinessException businessException = new BusinessException();
		Utilisateur utilisateur = null;
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

		// vérifier la conformité des saisies (par rapport à un modèle ou à une taille
		// maxi)
		this.verifierMDP(motDePasse, businessException);
		this.verifierEmail(email, businessException);
		this.verifierFormatTelephone(telephone, businessException);

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
		this.verifierFormatEmailMDP(email, businessException);
		if (businessException.hasErreurs()) {
			throw businessException;
		}

		utilisateur.setPseudo(pseudo);
		utilisateur.setPrenom(prenom);
		utilisateur.setNom(nom);
		utilisateur.setMotDePasse(motDePasse);
		utilisateur.setEmail(email);
		utilisateur.setTelephone(telephone);
		utilisateur.setRue(rue);
		utilisateur.setVille(ville);
		utilisateur.setCodePostal(codePostal);
		utilisateur.setCredit(100);
		utilisateur.setAdministrateur(false);
		inscriptionDao.insertUtilisateur(utilisateur);
		return utilisateur;
	}

	// Minimum 8 caractères, une minuscule, une majuscule, un caractère spécial.
	public boolean verifierMDP(String MotDePasse, BusinessException businessException) {
		// Expression régulière pour vérifier le format du mot de passe
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

		// Vérifier si le mot de passe correspond au format
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(MotDePasse);

		return matcher.matches();
	}

	public boolean verifierEmail(String email, BusinessException businessException) {
		// Expression régulière pour vérifier le format de l'email
		String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

		// Vérifier si l'email correspond au format
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(email);

		return matcher.matches();
	}

	public boolean validerTelephone(String telephone, BusinessException businessException) {
		// Expression régulière pour vérifier le format du numéro de téléphone
		String pattern = "^\\+(?:[0-9] ?){6,14}[0-9]$";

		// Vérifier si le numéro de téléphone correspond au format
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(telephone);

		return matcher.matches();
	}

	private void verifierUnicitePseudo(String pseudo, BusinessException businessException) {
		// TODO Auto-generated method stub

	}

	private void verifierTailleChamps(String champs, int i, BusinessException businessException) {
		int longueur = champs.length();

	}

	private void verifierFormatTelephone(String telephone, BusinessException businessException) {
		Pattern pattern = Pattern
				.compile("\\\\b(\\\\d{2})[- .]?(\\\\d{2})[- .]?(\\\\d{2})[- .]?(\\\\d{2})[- .]?(\\\\d{2})\\\\b$");
		Matcher matcher = pattern.matcher(telephone);
		return;

	}

	// private void verifierConformiteMotDePasse(String motDePasse,
	// BusinessException businessException) {
	// TODO Auto-generated method stub

	// }

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

//	private void verifierFormatEmailMDP(String email, BusinessException businessException) {
//		Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
//		Matcher matcher = pattern.matcher(email);
//		return;
//		
//	}

}
