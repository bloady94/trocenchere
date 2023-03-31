package fr.eni.trocenchere.connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.CodesResultatDAL;

public class ConnexionDAOJdbcImpl implements ConnexionDAO{
	
	//private static final String SELECT_CONNEXION_PSEUDO= "SELECT * FROM utilisateur WHERE pseudo = ? AND mot_de_passe = ?";
	//private static final String SELECT_CONNEXION_EMAIL= "SELECT * FROM utilisateur WHERE email = ? AND mot_de_passe = ?";
	
	

	private static final String SELECT_ID_MDP = "SELECT * FROM utilisateur WHERE (pseudo = ? OR email = ?) AND mot_de_passe = ?";

	
	
	public Utilisateur selectPseudoEmailMDP(String pseudoOuEmail, String motDePasse) throws BusinessException {
		
		// creation d'un nouvel utilisateur
		Utilisateur utilisateur = new Utilisateur();
		
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
            	utilisateur.setPseudo(rs.getString(pseudoOuEmail));
            	utilisateur.setEmail(rs.getString(pseudoOuEmail));
            	utilisateur.setMotDePasse(rs.getString(motDePasse));
			}
        }catch(Exception e)
        {
            e.printStackTrace();

        }
		// Retourner utilisateur avec les données qu'on lui a demandé de chercher.
		return  utilisateur;

	}
	
	
	/*
	public Utilisateur verificationEmail(String email, String motDePasse) throws BusinessException {
		
		Utilisateur utilisateur = new Utilisateur();
		
		try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_CONNEXION_EMAIL);
            
            pstmt.setString(1, email);
            pstmt.setString(2, motDePasse);
            
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	utilisateur.setPseudo(rs.getString(email));
            	utilisateur.setMotDePasse(rs.getString(motDePasse));
			}
        }catch(Exception e)
        {
            e.printStackTrace();

        }
		return  utilisateur;

	}
	*/
	

}