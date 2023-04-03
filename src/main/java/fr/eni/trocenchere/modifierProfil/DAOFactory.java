package fr.eni.trocenchere.modifierProfil;


public class DAOFactory {
	public static ModifierProfilDAO getModifierProfilDAO() {
		return new ModifierProfilDAOJdbcImpl();
	}
}
