package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.CodesResultatDAL;
import fr.eni.trocenchere.dal.ProfilDAO;

public class ProfilDAOJdbcImpl implements ProfilDAO {

	private static final String SELECT_UTILISATEUR_BY_MDP= "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, "
			+ "mot_de_passe, credit, administrateur FROM utilisateur WHERE mot_de_passe = ?";
	
	private static final String SELECT_UTILISATEUR_BY_NO= "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, "
			+ "mot_de_passe, credit, administrateur FROM utilisateur WHERE no_utilisateur = ?";
	
	@Override
	public Utilisateur selectUtilisateurByMDP(String mdpUtilisateur) throws BusinessException {
		 Utilisateur utilisateurTest = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_MDP);
            pstmt.setString(1, mdpUtilisateur);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
            	Integer utilisateurNo = rs.getInt("no_utilisateur");
                String utilisateurPseudo = rs.getString("pseudo");
                String utilisateurNom = rs.getString("nom");
                String utilisateurPrenom = rs.getString("prenom");
                String utilisateurEmail = rs.getString("email");
                String utilisateurTelephone = rs.getString("telephone");
                String utilisateurRue = rs.getString("rue");
                String utilisateurCodePostal = rs.getString("code_postal");
                String utilisateurVille = rs.getString("ville");
                String utilisateurMotDePasse = rs.getString("mot_de_passe");
                Integer utilisateurCredit = rs.getInt("credit");
                Boolean utilisateurAdministrateur = rs.getBoolean("administrateur");
                
                
                   
                    utilisateurTest.setNoUtilisateur(utilisateurNo);
                    utilisateurTest.setPseudo(utilisateurPseudo); 
                    utilisateurTest.setNom(utilisateurNom);
                    utilisateurTest.setPrenom(utilisateurPrenom);
                    utilisateurTest.setEmail(utilisateurEmail);
                    utilisateurTest.setTelephone(utilisateurTelephone);
                    utilisateurTest.setRue(utilisateurRue);
                    utilisateurTest.setCodePostal(utilisateurCodePostal);
                    utilisateurTest.setVille(utilisateurVille);
                    utilisateurTest.setMotDePasse(utilisateurMotDePasse);
                    utilisateurTest.setCredit(utilisateurCredit);
                    utilisateurTest.setAdministrateur(utilisateurAdministrateur);
                
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
            throw businessException;
        }
		return utilisateurTest;
	}

	@Override
	public Utilisateur selectUtilisateurByNo(Integer noUtilisateur) throws BusinessException {
		 Utilisateur utilisateurTest = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_NO);
            pstmt.setInt(1, noUtilisateur);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
            	Integer utilisateurNo = rs.getInt("no_utilisateur");
                String utilisateurPseudo = rs.getString("pseudo");
                String utilisateurNom = rs.getString("nom");
                String utilisateurPrenom = rs.getString("prenom");
                String utilisateurEmail = rs.getString("email");
                String utilisateurTelephone = rs.getString("telephone");
                String utilisateurRue = rs.getString("rue");
                String utilisateurCodePostal = rs.getString("code_postal");
                String utilisateurVille = rs.getString("ville");
                String utilisateurMotDePasse = rs.getString("mot_de_passe");
                Integer utilisateurCredit = rs.getInt("credit");
                Boolean utilisateurAdministrateur = rs.getBoolean("administrateur");
                
                
                   
                    utilisateurTest.setNoUtilisateur(utilisateurNo);
                    utilisateurTest.setPseudo(utilisateurPseudo); 
                    utilisateurTest.setNom(utilisateurNom);
                    utilisateurTest.setPrenom(utilisateurPrenom);
                    utilisateurTest.setEmail(utilisateurEmail);
                    utilisateurTest.setTelephone(utilisateurTelephone);
                    utilisateurTest.setRue(utilisateurRue);
                    utilisateurTest.setCodePostal(utilisateurCodePostal);
                    utilisateurTest.setVille(utilisateurVille);
                    utilisateurTest.setMotDePasse(utilisateurMotDePasse);
                    utilisateurTest.setCredit(utilisateurCredit);
                    utilisateurTest.setAdministrateur(utilisateurAdministrateur);
                
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
            throw businessException;
        }
		return utilisateurTest;
	}

}
