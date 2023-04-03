package fr.eni.trocenchere.bll;

public class ConnexionSing {
	
	private static ConnexionManager instance;
	
	public static ConnexionManager getInstance() {
		if(instance==null) {
			instance = new ConnexionManager();
		}
		return instance;
	}

}
