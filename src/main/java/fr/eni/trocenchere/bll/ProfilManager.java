package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.ProfilDAO;

public class ProfilManager {

	
		private ProfilDAO profilDao;
		
		public ProfilManager() {
			this.profilDao=DAOFactory.getProfilDAO();
		}
		
		public Utilisateur afficherProfil(Utilisateur utilisateur) throws BusinessException 
		{
			
			BusinessException businessException = new BusinessException();
			Utilisateur utilisateurTest = new Utilisateur();
			
			if(!businessException.hasErreurs())
			{
				utilisateurTest = profilDao.select_utilisateur(utilisateur);
			}
			else
			{
				utilisateurTest = null;
				throw businessException;
			}
			return utilisateurTest;
		}
}
