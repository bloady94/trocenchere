package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.ModifierProfilDAO;


public class ModifierProfilDAOJdbcImpl implements ModifierProfilDAO{

	private static final String UPDATE_UTILISATEUR = "UPDATE utilisateur SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur = ?";


	@Override
	public void update_utilisateur(Utilisateur utilisateur) throws BusinessException {

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			//Préciser dans la fonction à quel niveau faire la modification (numéro id de l'utilisateur)
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getNoUtilisateur());
			
			ResultSet rs = pstmt.executeQuery();
			
			String pseudo = rs.getString("pseudo");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String telephone = rs.getString("telephone");
			String rue = rs.getString("rue");
			String codePostal = rs.getString("code_postal");
			String ville = rs.getString("ville");
			String motDePasse = rs.getString("mot_de_passe");
			Integer noUtilisateur = rs.getInt("no_utilisateur");
			
			Utilisateur user = new Utilisateur();
			
			user.setNoUtilisateur(noUtilisateur);
			user.setPseudo(pseudo);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setTelephone(telephone);
			user.setRue(rue);
			user.setCodePostal(codePostal);
			user.setVille(ville);
			user.setMotDePasse(motDePasse);


		} catch (Exception e) {
			e.printStackTrace();

		}

	}


}
