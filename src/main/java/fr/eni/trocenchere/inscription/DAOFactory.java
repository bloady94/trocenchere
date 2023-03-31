package fr.eni.trocenchere.inscription;

public class DAOFactory {

	public static inscriptionDAO getInscriptionDAO() {
		return new InscriptionDAOJdbcImpl();
	}
}
