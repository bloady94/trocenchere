package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.AjoutArticleDAO;
import fr.eni.trocenchere.dal.CodesResultatDAL;


public class AjoutArticleDAOJdbcImpl implements AjoutArticleDAO{

	private static final String INSERT_ARTICLEVENDU = "INSERT INTO articlevendu (nom, description, date_debut_enchere, date_fin_enchere, " 
												+ "prix_initial, Utilisateur_no_utilisateur, Categorie_no_categorie)" 
												+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		
	

	private void ajoutArticle(ArticleVendu articleVendu) throws Exception {
	
	try (Connection con = ConnectionProvider.getConnection()) {
		PreparedStatement pstmt = con.prepareStatement(INSERT_ARTICLEVENDU, PreparedStatement.RETURN_GENERATED_KEYS);

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

	}catch (Exception e) {
		
		e.printStackTrace();
	}
	
	}


	public List<ArticleVendu> selectByCategorieArticle(String LibCat) throws BusinessException { 
		List<ArticleVendu> articles = null;
		ArticleVendu article = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) { PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
		pstmt.setString(1, LibCat);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) { Integer noArticle = rs.getInt(1);
		String nomArticle = rs.getString(2);
		String description = rs.getString(3);
		LocalDate debutEnchere = null;
		rs.getDate(4);
		
		if (!rs.wasNull()) { debutEnchere = rs.getDate(4).toLocalDate();
		} LocalDate finEnchere = null;
		rs.getDate(5);
		if (!rs.wasNull()) { finEnchere = rs.getDate(5).toLocalDate();
		}
		Integer prixInitial = rs.getInt(6);
		Integer NoUtililisateur = rs.getInt(7);
		Utilisateur utilisateur = (Utilisateur) new Utilisateur().selectByIdUtilisateur(NoUtililisateur);
		Categorie categorie = new Categorie(rs.getInt(9), LibCat);
		
		article = new ArticleVendu(noArticle, nomArticle, description, debutEnchere, finEnchere, prixInitial, utilisateur, categorie);
		
		if (articles == null) { articles = new ArrayList<ArticleVendu>();
		} articles.add(article);
		} } catch (Exception e) { e.printStackTrace(); BusinessException businessException = new BusinessException();
		businessException.ajouterErreur(CodesResultatDAL.SELECT_BY_NOM_ECHEC); throw businessException; } return articles; }
	
	
	@Override
	public void ajoutarticle(ArticleVendu articleVendu) throws BusinessException {
		// TODO Auto-generated method stub
		
	}



	
	
	
	
	/*public class MenuDeroulantPrix extends JFrame {
		  private JComboBox<Integer> comboBox;
		  
		  public MenuDeroulantPrix() {
		    Integer[] prix = new Integer[101];
		    for (int i = 0; i <= 100; i++) {
		      prix[i] = i;
		    }
		    comboBox = new JComboBox<Integer>(prix);
		    add(comboBox);
		    pack();
		    setVisible(true);
		  }
		  
		  public void main(String[] args) {
		    new MenuDeroulantPrix();
		  }
		}*/

}

