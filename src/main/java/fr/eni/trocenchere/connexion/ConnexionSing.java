package fr.eni.trocenchere.connexion;

public class ConnexionSing {
	
	private static ConnexionDAO instance;
	
	public static ConnexionDAO getConnexionDAO() {
		if(instance==null) {
			instance = new ConnexionDAOJdbcImpl();
		}
		return instance;
	}

}
