package fr.eni.trocenchere.inscription;

public class InscriptionSing {
	
	private static InscriptionManager instance;
	
	public static InscriptionManager getInstance() {
		if(instance==null) {
			instance = new InscriptionManager();
		}
		return instance;
	}
}
