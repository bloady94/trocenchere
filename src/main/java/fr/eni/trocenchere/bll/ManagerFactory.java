package fr.eni.trocenchere.bll;

public class ManagerFactory {
	public static ProfilManager getProfilManager() {
		return new ProfilManagerImpl();
	}
}

