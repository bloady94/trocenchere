package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DAOFactory;
import fr.eni.trocenchere.dal.ProfilDAO;

public class ProfilManagerImpl implements ProfilManager {

	private ProfilDAO profilDao;

	public ProfilManagerImpl() {
		this.profilDao = DAOFactory.getProfilDAO();
	}

	public Utilisateur selectUtilisateurByMDP(String mdpUtilisateur) throws BusinessException {
		return profilDao.selectUtilisateurByMDP(mdpUtilisateur);
	}

	@Override
	public Utilisateur selectUtilisateurByNo(Integer noUtilisateur) throws BusinessException {
		return profilDao.selectUtilisateurByNo(noUtilisateur);
	}


}
