package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.dal.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String INSERT_ARTICLEVENDU = "INSERT INTO articlevendu (nom, description, date_debut_enchere, date_fin_enchere, "
			+ "prix_initial, Utilisateur_no_utilisateur, Categorie_no_categorie)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void ajoutarticle(ArticleVendu articleVendu) throws BusinessException {

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(INSERT_ARTICLEVENDU,
					PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, articleVendu.getNomArticle());
			pstmt.setString(2, articleVendu.getDescription());
			pstmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDebutEnchere()));
			pstmt.setDate(4, java.sql.Date.valueOf(articleVendu.getFinEnchere()));
			pstmt.setInt(5, articleVendu.getPrixInitial());
			pstmt.setInt(7, articleVendu.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(8, articleVendu.getCategorie().getNoCategorie());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				articleVendu.setNoArticle(rs.getInt(1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}


	@Override
	public List<ArticleVendu> selectArticles() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public class MenuDeroulantPrix extends JFrame { private JComboBox<Integer>
	 * comboBox;
	 * 
	 * public MenuDeroulantPrix() { Integer[] prix = new Integer[101]; for (int i =
	 * 0; i <= 100; i++) { prix[i] = i; } comboBox = new JComboBox<Integer>(prix);
	 * add(comboBox); pack(); setVisible(true); }
	 * 
	 * public void main(String[] args) { new MenuDeroulantPrix(); } }
	 */

}
