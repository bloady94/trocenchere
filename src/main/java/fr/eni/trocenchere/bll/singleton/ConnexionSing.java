package fr.eni.trocenchere.bll.singleton;

import fr.eni.trocenchere.bll.ConnexionManager;

public class ConnexionSing {
	
	private static ConnexionManager instance;
	
	public static ConnexionManager getInstance() {
		if(instance==null) {
			instance = new ConnexionManager();
		}
		return instance;
	}

}
