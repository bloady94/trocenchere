package fr.eni.trocenchere.inscription;

public class DAOFactory {

	public static InscriptionDAO getInscriptionDAO() {
		return new InscriptionDAOJdbcImpl(); 
	}
	
	// modif
}
