package fr.eni.trocenchere.aficherProfil;


public class DAOFactory {

	public static ProfilDAO getProfilDAO() {
		return new ProfilDAOJdbcImpl();
	}
}
