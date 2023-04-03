package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.ConnexionDAO;
import fr.eni.trocenchere.dal.jdbc.ConnexionDAOJdbcImpl;

public class ConnexionManager {

	private ConnexionDAO connexionDAO;

	public ConnexionManager() {
		this.connexionDAO = new ConnexionDAOJdbcImpl();
	}

	
	BusinessException businessException = new BusinessException();
	
	// Méthode "authentification qui prend en paramètre pseudoOuEmail et le
	// motDePasse
	public Utilisateur authentification(String pseudoOuEmail, String motDePasse)throws BusinessException{
		
		/*
		 *  Création d'un utilisateur dans lequel on va mettre la méthode selectPseudoEmailMDP, on renseigne dedans 
		 *  le pseudoOuEmail et le motDePase
		 */
		Utilisateur user = null;
		
		if(!businessException.hasErreurs()) { 
			
			user = connexionDAO.selectPseudoEmailMDP(pseudoOuEmail, motDePasse); 
			
			} else { 
				
			throw businessException; 
			}
		
		// On retourn l'user.
		return user;
	}
	
}
