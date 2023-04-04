package fr.eni.trocenchere.bll.singleton;

import fr.eni.trocenchere.bll.ModifierProfilManager;

public class ModifierSing {
	
	private static ModifierProfilManager instance;
	
	public static ModifierProfilManager getInstance() {
		if(instance==null) {
			instance = new ModifierProfilManager();
		}
		return instance;
	}
}