package fr.eni.trocenchere.bll.singleton;

import fr.eni.trocenchere.bll.InscriptionManager;

public class InscriptionSing {
	
	private static InscriptionManager instance;
	
	public static InscriptionManager getInstance() {
		if(instance==null) {
			instance = new InscriptionManager();
		}
		return instance;
	}
	

}
