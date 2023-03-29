package fr.eni.trocenchere.connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.CodesResultatDAL;

public class ConnexionDAOJdbcImpl implements ConnexionDAO{
	
	// TODO A VERIFIER SI C'EST CORRECT
	private static final String SELECT_CONNEXION_PSEUDO= "SELECT utilisateur (pseudo, mot_de_passe) WHERE pseudo = ? AND mot_de_passe = ?";
	private static final String SELECT_CONNEXION_EMAIL= "SELECT utilisateur (email, mot_de_passe) WHERE email = ? AND mot_de_passe = ?";

	@Override
	public Utilisateur select_connexionPseudo(String pseudo, String motDePasse) throws BusinessException {
		
		Utilisateur utilisateurTest = new Utilisateur();

		try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_CONNEXION_PSEUDO);
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
                
                if(utilisateurTest.getPseudo().equals(pseudo) && utilisateurTest.getMotDePasse().equals(motDePasse)){
                    utilisateurTest = new Utilisateur();
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
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
            throw businessException;
        }
		return  utilisateurTest;

	}

	@Override
	public Utilisateur select_connexionEmail(String email, String motDePasse) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
