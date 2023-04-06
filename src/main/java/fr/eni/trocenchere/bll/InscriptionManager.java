package fr.eni.trocenchere.bll;



import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DAOFactory;
import fr.eni.trocenchere.dal.InscriptionDAO;

public class InscriptionManager {
	private InscriptionDAO inscriptionDAO;

	public InscriptionManager() {
		this.inscriptionDAO = DAOFactory.getInscriptionDAO();
	}

	public Utilisateur ajouterUtilisateur1(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur)
			throws BusinessException {

		BusinessException businessException = new BusinessException();
		
		Utilisateur utilisateurTemp = null; 

		/*
		 * On va v�rifier si les les champs non null sont bien renseign�s. Il y a deux
		 * param�tres ; - Le 1er : c'est ce qu'a �crit l'utilisateur - Le 2emm : c'est
		 * pour pr�ciser ce que l'on v�rifie (pour plus- de clart� s'il y a un message
		 * d'erreur)
		 */
		this.verifNullite(pseudo, "pseudo");
		this.verifNullite(nom, "nom");
		this.verifNullite(prenom, "prenom");
		this.verifNullite(email, "email");
		this.verifNullite(rue, "rue");
		this.verifNullite(codePostal, "codePostal");
		this.verifNullite(ville, "ville");
		this.verifNullite(motDePasse, "motDePasse");

		
		
		
		/* 
		 *  Donc, apres avoir v�rifier que les infos soient bien renseign�es,
		 *  on va les set dans l'utilisateur que l'on a cr�e plus haut
		 */
		utilisateurTemp = new Utilisateur();
		utilisateurTemp.setPseudo(pseudo);
		utilisateurTemp.setNom(nom);
		utilisateurTemp.setPrenom(prenom);
		utilisateurTemp.setEmail(email);
		utilisateurTemp.setTelephone(telephone);
		utilisateurTemp.setRue(rue);
		utilisateurTemp.setCodePostal(codePostal);
		utilisateurTemp.setVille(ville);
		utilisateurTemp.setMotDePasse(motDePasse);
		utilisateurTemp.setCredit(credit);
		utilisateurTemp.setAdministrateur(administrateur);
		
		
		if(!businessException.hasErreurs()) { 
			
			inscriptionDAO.insertUtilisateur(utilisateurTemp);

			} else { 
				
			throw businessException; 
			}

		return utilisateurTemp;	
	}

	private void verifNullite(String parametre, String nomParametre) {
		
		/* 
		 * Donc si parametre est null on balance une business exception
		 * Ou alors, on prend le param�tre, on enleve les espaces devant et derri�re grace � .trim()
		 * et on check si le champ est vide avec .isEmpty()
		 * si c'est le cas on balance aussi une exception.
		 */
		if (parametre == null || parametre.trim().isEmpty()) {
			
			// Cr�ation de l'exception
			BusinessException businessException = new BusinessException();
			
			// On ajouter l'erreur et on pr�cise ce qu'elle renvoie
			businessException.ajouterErreur("Le champ " + nomParametre + " est obligatoire connard !");
			
		}
	}
	

}
