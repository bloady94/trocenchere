package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.dal.jdbc.ConnexionDAOJdbcImpl;
import fr.eni.trocenchere.dal.jdbc.EncheresDAOJdbcImpl;
import fr.eni.trocenchere.dal.jdbc.InscriptionDAOJdbcImpl;
import fr.eni.trocenchere.dal.jdbc.ModifierProfilDAOJdbcImpl;
import fr.eni.trocenchere.dal.jdbc.ProfilDAOJdbcImpl;

public class DAOFactory {
	public static ModifierProfilDAO getModifierProfilDAO() {
		return new ModifierProfilDAOJdbcImpl();
	}
	
	public static InscriptionDAO getInscriptionDAO() {
		return new InscriptionDAOJdbcImpl(); 
	}
	
	public static EncheresDAO getEncheresDAO() {
		return new EncheresDAOJdbcImpl();
	}
	
	public static ProfilDAO getProfilDAO() {
		return new ProfilDAOJdbcImpl();
	}
	
	public static ConnexionDAO getConnexionDAO() {
		return new ConnexionDAOJdbcImpl();
	}
}
