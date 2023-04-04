package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.ArticleDAO;
import fr.eni.trocenchere.dal.CodesResultatDAL;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String INSERT_ARTICLEVENDU = "INSERT INTO articlevendu (nom, description, date_debut_enchere, date_fin_enchere, "
			+ "prix_initial, Utilisateur_no_utilisateur, Categorie_no_categorie)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SELECT_ARTICLES = "SELECT a.nom as nomArticle, description, date_debut_enchere, date_fin_enchere, prix_initial, "
			+ "prix_vente, Utilisateur_no_utilisateur, Categorie_no_categorie, libelle FROM articlevendu as a"
			+ "left join categorie as c on c.no_categorie = a.Categorie_no_categorie"
			+ "left join utilisateur as u on u.no_utilisateur = a.Utilisateur_no_utilisateur";

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
/*	public List<ArticleVendu> selectArticles() throws BusinessException {

		List<ArticleVendu> articles = null;
		ArticleVendu article = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLES);
			pstmt.setString(1, );
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Integer noArticle = rs.getInt(1);
				String nomArticle = rs.getString(2);
				String description = rs.getString(3);
				LocalDate debutEnchere = null;
				rs.getDate(4);

				if (!rs.wasNull()) {
					debutEnchere = rs.getDate(4).toLocalDate();
				}
				LocalDate finEnchere = null;
				rs.getDate(5);
				if (!rs.wasNull()) {
					finEnchere = rs.getDate(5).toLocalDate();
				}
				Integer prixInitial = rs.getInt(6);
				Integer NoUtililisateur = rs.getInt(7);
				Utilisateur utilisateur = (Utilisateur) new Utilisateur().SELECT_UTILISATEUR(NoUtililisateur);
				Categorie categorie = new Categorie(rs.getInt(9));

				article = new ArticleVendu(noArticle, nomArticle, description, debutEnchere, finEnchere, prixInitial,
						utilisateur, categorie);

				if (articles == null) {
					articles = new ArrayList<ArticleVendu>();
				}
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL);
			throw businessException;
		}
		return articles;
	}*/

	List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>(),
	
	try(
	Connection cnx = ConnectionProvider.getConnection())
	{
		PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLES);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			// ETAPE 1 : récupération des valeurs pour la ligne depuis la base
			Integer noArticle = rs.getInt("no_article");
			String articleNom = rs.getString("nomArticle");
			String articleDescription = rs.getString("dscription");
			LocalDate articleDateDebut = rs.getDate("date_debut_enchere").toLocalDate();
			LocalDate articleDateFin = rs.getDate("date_fin_enchere").toLocalDate();
			Integer prixInitial = rs.getInt("prix_initial");
			Integer prixFinal = rs.getInt("prix_vente");

			Categorie categorie = new Categorie(rs.getInt("Categorie_no_categorie"), rs.getString("libelle"));

			Utilisateur utilisateur = new Utilisateur(rs.getInt("Utilisateur_no_utilisateur"), rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone");
			
			ArticleVendu articleTest = new ArticleVendu();
			
			articleTest.setNomArticle(articleNom);
			articleTest.setDescription(articleDescription);
			articleTest.setDebutEnchere(articleDateDebut);
			articleTest.setFinEnchere(articleDateFin);
			articleTest.setPrixInitial(prixInitial);
			articleTest.setPrixFinal(prixFinal);

			articleTest.setUtilisateur(utilisateur);
			articleTest.setCategorie(categorie);
			
			listeArticles.add(articleTest);
		}
	}catch(
	Exception e)
	{
		e.printStackTrace();
		BusinessException businessException = new BusinessException();
		businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
		throw businessException;
	}return listeArticles;
}

}
