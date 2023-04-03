package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.ConnectionProvider;
import fr.eni.trocenchere.dal.ConnexionDAO;

public class ConnexionDAOJdbcImpl implements ConnexionDAO{
	

	private static final String SELECT_ID_MDP = "SELECT * FROM utilisateur WHERE (pseudo = ? OR email = ?) AND mot_de_passe = ?";

	
	
	public Utilisateur selectPseudoEmailMDP(String pseudoOuEmail, String motDePasse) throws BusinessException {
		
		// creation d'un nouvel utilisateur
		Utilisateur utilisateur = null;
		
		try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ID_MDP);
            
            // Setting de ce que l'on va chercher
           pstmt.setString(1, pseudoOuEmail);
            pstmt.setString(2, pseudoOuEmail);
            pstmt.setString(3, motDePasse);
            
            // Stock tout dans un tableau ResultSet
            ResultSet rs = pstmt.executeQuery();

            // Tant qu'il y a une ligne après tu add dans utilisateur :
            while (rs.next()) {
            	utilisateur = new Utilisateur();
            	utilisateur.setPseudo(rs.getString("pseudo"));
            	utilisateur.setEmail(rs.getString("email"));
            	utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
			}
        }catch(Exception e)
        {
            e.printStackTrace();

        }
		// Retourner utilisateur avec les données qu'on lui a demandé de chercher.
		return utilisateur;

	}
	
}