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
	private static final String SELECT_ARTICLES = "SELECT no_article, nom, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, Utilisateur_no_utilisateur, Categorie_no_categorie FROM articlevendu";

	
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
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		ArticleVendu articleTest =new ArticleVendu();
        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLES);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                // ETAPE 1 : récupération des valeurs pour la ligne depuis la base
                
            	Integer noArticle = rs.getInt("no_article");
                String articleNom = rs.getString("nom");
                String articleDescription = rs.getString("description");
                LocalDate articleDateDebut = rs.getDate("date_debut_enchere").toLocalDate();
                LocalDate articleDateFin = rs.getDate("date_fin_enchere").toLocalDate();
                Integer prixInitial = rs.getInt("prix_initial");
                Integer prixFinal = rs.getInt("prix_vente");
               
                
               int noUtilisateur =  rs.getInt("Utilisateur_no_utilisateur");
                
               	// TODO UtilisateurDAO utilDAO = UtilisateurDAOJdbcImpl();
               			
               //Utilisateur util = utilDAO.seletcByID(noUtilisateur);
               	
                int noCategorie = rs.getInt("Categorie_no_categorie");
                
             // TODO CategorieDAO categorieDAO = CategorieDAOJdbcImpl();
       			
                //Categorie categorie = categorieDAO.seletcByID(noCategorie);
                
                // ETAPE 2 : au besoin, on créé un nouveau repas courant
                if(articleTest.getNoArticle() == null){ // factorisable également pour n'avoir qu'un seul if
                    articleTest.setNomArticle(articleNom); 
                    articleTest.setDescription(articleDescription); 
                    articleTest.setDebutEnchere(articleDateDebut); 
                    articleTest.setFinEnchere(articleDateFin); 
                    articleTest.setPrixInitial(prixInitial); 
                    articleTest.setPrixFinal(prixFinal); 
                   // articleTest.setUtilisateur(util); 
                   // articleTest.setCategorie(categorie); 
                    listeArticles.add(articleTest);
                } else if(!noArticle.equals(articleTest.getNoArticle())){
                	articleTest = new ArticleVendu();
                	articleTest.setNomArticle(articleNom); 
                    articleTest.setDescription(articleDescription); 
                    articleTest.setDebutEnchere(articleDateDebut); 
                    articleTest.setFinEnchere(articleDateFin); 
                    articleTest.setPrixInitial(prixInitial); 
                    articleTest.setPrixFinal(prixFinal); 
                   // articleTest.setUtilisateur(util); 
                   // articleTest.setCategorie(categorie);
                	listeArticles.add(articleTest);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
            throw businessException;
        }
        return listeArticles;
	}

}
