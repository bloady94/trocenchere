package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.dal.CategorieDAO;
import fr.eni.trocenchere.dal.CodesResultatDAL;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	private static final String SELECT_CATEGORIE = "SELECT no_categorie, libelle FROM categorie WHERE no_categorie = ?";

	
	@Override
	public Categorie selectById(Integer noCategorie) throws BusinessException {

		Categorie categorieTest = new Categorie();
		try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_CATEGORIE);
            pstmt.setInt(1, noCategorie);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
            	// maybe new categorie there ?
            	Integer categorieNo = rs.getInt("no_categorie");
                String categorieLibelle = rs.getString("libelle");
                
                	
                	categorieTest.setNoCategorie(categorieNo);
                	categorieTest.setLibelle(categorieLibelle);
                
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
            throw businessException;
        }
		return categorieTest;
	}
	

}
