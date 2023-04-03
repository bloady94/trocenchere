package fr.eni.trocenchere.bll;

public class ModifierSing {
	
	private static ModifierProfilManager instance;
	
	public static ModifierProfilManager getInstance() {
		if(instance==null) {
			instance = new ModifierProfilManager();
		}
		return instance;
	}

}