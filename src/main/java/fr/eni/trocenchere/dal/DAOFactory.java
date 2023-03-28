package fr.eni.trocenchere.dal;


public class DAOFactory {

	public static EncheresDAO getEncheresDAO() {
		return new EncheresDAOJdbcImpl();
	}
}
