package fr.eni.trocenchere.bll.singleton;

import fr.eni.trocenchere.bll.ModifierProfilManager;
import fr.eni.trocenchere.bll.ModifierProfilManagerImpl;

public class ModifierProfilManagerSingl {
	
	private static ModifierProfilManager instance;
	
	public static ModifierProfilManager getInstance() {
		if(instance==null) {
			instance = new ModifierProfilManagerImpl();
		}
		return instance;
	}
}