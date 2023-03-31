package fr.eni.trocenchere.connexion;


public class DAOFactory {
	public static ConnexionDAO getConnexionDAO() {
		return new ConnexionDAOJdbcImpl();
	}
}