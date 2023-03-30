package fr.eni.trocenchere.connexion;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public class ConnexionManager {

	private ConnexionDAO connexionDao;
	
	public ConnexionManager() {
		this.connexionDao=DAOFactory.getConnexionDAO();
	}
	
	public Utilisateur connexionPseudo(String pseudo, String motDePasse) throws BusinessException 
	{
		
		BusinessException businessException = new BusinessException();
		Utilisateur utilisateurTest = new Utilisateur();
		
		// Si businessException est vrai, alors : 
		if(!businessException.hasErreurs())
		{
			/*
			 *  On insère dans la variable utilisateurTest la méthode "select_connexionPseudo"
			 *  qui se trouve dans l'interface "ConnexionDAO", on lui passe en paramètre les 
			 *  les données que l'on veut récupérer dans la base.
			 */
			utilisateurTest = connexionDao.select_connexionPseudo(pseudo, motDePasse);
		}
		else
		{
			// Si businessException est faux, alors utilisateurTest est null et on balance une exception
			utilisateurTest = null;
			throw businessException;
		}
		// On retourne le contenu de utilisateurTest (pseudo et MDP ou alors NULL)
		return utilisateurTest;
	}
	
	
	public Utilisateur connexionEmail(String email, String motDePasse) throws BusinessException 
	{
		
		BusinessException businessException = new BusinessException();
		Utilisateur utilisateurTest = new Utilisateur();
		
		if(!businessException.hasErreurs())
		{

			utilisateurTest = connexionDao.select_connexionPseudo(email, motDePasse);
		}
		else
		{
			utilisateurTest = null;
			throw businessException;
		}
		return utilisateurTest;
	}
}
