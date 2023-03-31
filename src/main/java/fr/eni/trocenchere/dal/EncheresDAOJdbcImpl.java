package fr.eni.trocenchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.bo.Retrait;
import fr.eni.trocenchere.bo.Utilisateur;

public class EncheresDAOJdbcImpl implements EncheresDAO {

	private static final String INSERT_UTILISATEUR = "INSERT INTO utilisateur (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
													+"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_ARTICLEVENDU = "INSERT INTO articlevendu (nom, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, Utilisateur_no_utilisateur, Categorie_no_categorie) "
													+ "VALUES (?,?,?,?,?,?,?,?)";
	
	private static final String INSERT_ENCHERE = "INSERT INTO enchere (date_enchere, montant_enchere, Utilisateur_no_utilisateur, ArticleVendu_no_article) VALUES(?,?,?,?)";
	
	private static final String INSERT_RETRAIT = "INSERT INTO retrait (rue, code_postal, ville, ArticleVendu_no_article) VALUES(?,?,?,?)";
	
	private static final String INSERT_CATEGORIE = "INSERT INTO categorie (libelle) VALUES (?) ";
	
	private static final String DELETE_UTILISATEUR = "DELETE FROM utilisateur WHERE no_utilisateur = ?";
	
	private static final String DELETE_ARTICLEVENDU = "DELETE FROM articlevendu WHERE no_article = ?";
			
	private static final String UPDATE_UTILISATEUR = "UPDATE utilisateur SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur = ?";

	private static final String UPDATE_ENCHERE = "UPDATE enchere SET date_enchere=?, montant_enchere=?, Utilisateur_no_utilisateur=?, ArticleVendu_no_article=? WHERE ArticleVendu_no_article = ?";
	
	private static final String SELECT_UTILISATEUR= "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM utilisateur WHERE no_utilisateur = ?";
	
	private static final String SELECT_ARTICLEVENDU = "SELECT nom, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, Utilisateur_no_utilisateur, Categorie_no_categorie FROM articlevendu WHERE Categorie_no_categorie = ?";
	
	

	@Override
	public void insert_utilisateur(Utilisateur utilisateur) throws BusinessException {

		if (utilisateur == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.isAdministrateur());
			
			pstmt.executeUpdate();
			

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
			BusinessException businessException = new BusinessException(); 
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC); 
			throw businessException;
		}


	}
	
	@Override
	public void insert_articleVendu(ArticleVendu articleVendu) throws BusinessException{
		
		if(articleVendu==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		Integer Utilisateur_no_utilisateur = articleVendu.getUtilisateur().getNoUtilisateur();
		Integer Categorie_no_categorie = articleVendu.getCategorie().getNoCategorie();
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(INSERT_ARTICLEVENDU, PreparedStatement.RETURN_GENERATED_KEYS);
		
			
			pstmt.setString(1, articleVendu.getNomArticle());
			pstmt.setString(2, articleVendu.getDescription());
			pstmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDebutEnchere()));
			pstmt.setDate(4, java.sql.Date.valueOf(articleVendu.getFinEnchere()));
			pstmt.setInt(5,  articleVendu.getPrixInitial());
			pstmt.setInt(6,  articleVendu.getPrixFinal());
			pstmt.setInt(7,  Utilisateur_no_utilisateur);
			pstmt.setInt(8,  Categorie_no_categorie);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();		
			if(rs.next()) {
				articleVendu.setNoArticle(rs.getInt(1));
			}
		} catch (Exception  e) {
			e.printStackTrace();
		}
	}
			  
	@Override
	public void insert_enchere(Enchere enchere) throws BusinessException {
		if(enchere==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		Integer Utilisateur_no_utilisateur = enchere.getUtilisateur().getNoUtilisateur();
		Integer ArticleVendu_no_article = enchere.getArticle().getNoArticle();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, java.sql.Date.valueOf(enchere.getDateEnchere()));
			pstmt.setInt(2, enchere.getMontantEnchere());
			pstmt.setInt(3, Utilisateur_no_utilisateur);
			pstmt.setInt(4, ArticleVendu_no_article);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				enchere.setNoEnchere(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void insert_retrait(Retrait retrait) throws BusinessException {
		if(retrait==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		Integer ArticleVendu_no_article = retrait.getArticle().getNoArticle();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, retrait.getRue());
			pstmt.setString(2, retrait.getCodePostal());
			pstmt.setString(3, retrait.getVille());
			pstmt.setInt(4, ArticleVendu_no_article);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	@Override
	public void insert_categorie(Categorie categorie) throws BusinessException {
		if(categorie==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, categorie.getLibelle());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				categorie.setNoCategorie(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete_utilisateur(Utilisateur utilisateur) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_UTILISATEUR);

			pstmt.setInt(1, utilisateur.getNoUtilisateur());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
//			BusinessException businessException = new BusinessException();
//			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_LISTE_ERREUR);
//			throw businessException;
		}

	}

	@Override
	public void delete_articleVendu(ArticleVendu articleVendu) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(DELETE_ARTICLEVENDU);

			pstmt.setInt(1, articleVendu.getNoArticle());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
//			BusinessException businessException = new BusinessException();
//			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_LISTE_ERREUR);
//			throw businessException;
		}

	}

	@Override
	public void update_utilisateur(Utilisateur utilisateur) throws BusinessException {

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			//Préciser dans la fonction à quel niveau faire la modification (numéro id de l'utilisateur)
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.isAdministrateur());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
//			BusinessException businessException = new BusinessException();
//			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_LISTE_ERREUR);
//			throw businessException;
		}

	}

	@Override
	public void update_enchere(Enchere enchere) throws BusinessException {
		
		Integer Utilisateur_no_utilisateur = enchere.getUtilisateur().getNoUtilisateur();
		Integer ArticleVendu_no_article = enchere.getArticle().getNoArticle();
		
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ENCHERE);

			pstmt.setDate(1, java.sql.Date.valueOf(enchere.getDateEnchere()));
			pstmt.setInt(2, enchere.getMontantEnchere());
			pstmt.setInt(3, Utilisateur_no_utilisateur);
			pstmt.setInt(4, ArticleVendu_no_article);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
//			BusinessException businessException = new BusinessException();
//			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_LISTE_ERREUR);
//			throw businessException;
		}

	}

	@Override
	public Utilisateur select_utilisateur(Utilisateur utilisateur) throws BusinessException {
		Utilisateur utilisateurTest = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR);
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
                
                if(!utilisateurNo.equals(utilisateurTest.getNoUtilisateur())){
                    utilisateurTest = new Utilisateur();
                    utilisateurTest.setPseudo(utilisateurPseudo); // 4 lignes factorisables dans une fonction à part
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
	public void select_article(ArticleVendu articleVendu) throws BusinessException {
		// TODO Auto-generated method stub
		/*
		for (ArticleVendu av : utilisateur.getListeArticles()) {
			insert_articleVendu(av, utilisateur.getNo_utilisateur());
		}
		
		for (Enchere e : utilisateur.getListeEncheres() && ArticleVendu av : utilisateur.getListeArticles()) {
			insert_enchere(e, utilisateur.getNo_utilisateur(), av.getNo_Article());
		}

		 */
	}


}
