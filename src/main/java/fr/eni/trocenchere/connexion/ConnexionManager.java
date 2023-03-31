package fr.eni.trocenchere.connexion;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public class ConnexionManager {

	private ConnexionDAO connexionDAO;

	public ConnexionManager() {
		this.connexionDAO = new ConnexionDAOJdbcImpl();
	}

	// Ce constructeur permet à la classe ConnexionManager d'utiliser connexionDAO
	public ConnexionManager(ConnexionDAO connexionDAO) {
		this.connexionDAO = connexionDAO;
	}

	
	BusinessException businessException = new BusinessException();
	
	// Méthode "authentification qui prend en paramètre pseudoOuEmail et le
	// motDePasse
	public Utilisateur authentification(String pseudoOuEmail, String motDePasse)throws BusinessException{
		
		/*
		 *  Création d'un utilisateur dans lequel on va mettre la méthode selectPseudoEmailMDP, on renseigne dedans 
		 *  le pseudoOuEmail et le motDePase
		 */
		Utilisateur user = connexionDAO.selectPseudoEmailMDP(pseudoOuEmail, motDePasse);
		
		if(!businessException.hasErreurs()) { 
			
			user = connexionDAO.selectPseudoEmailMDP(pseudoOuEmail, motDePasse); 
			
			} else { user = null; 
			
			throw businessException; }
		
		// On retourn l'user.
		return user;
	}
	
}
