package fr.eni.trocenchere.aficherProfil;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

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
