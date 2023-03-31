package fr.eni.trocenchere.connexion;

public class ConnexionSing {
	
	private static ConnexionManager instance;
	
	public static ConnexionManager getInstance() {
		if(instance==null) {
			instance = new ConnexionManager();
		}
		return instance;
	}

}
