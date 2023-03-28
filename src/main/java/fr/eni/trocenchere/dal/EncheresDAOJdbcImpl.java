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
	private static final String INSERT_ARTICLEVENDU = "INSERT INTO articlevendu (nom, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, Utilisateur_no_utilisateur, Categorie_no_categeorie) "
													+ "VALUES (?,?,?,?,?,?,?,?)";
	
	private static final String INSERT_ENCHERE = "INSERT INTO enchere (date_enchere, montant_enchere, Utilisateur_no_utilisateur, ArticleVendu_no_article) VALUES(?,?,?,?)";
	
	private static final String INSERT_RETRAIT = "INSERT INTO retrait (rue, code_postal, ville, ArticleVendu_no_article) VALUES(?,?,?,?)";
	
	private static final String INSERT_CATEGORIE = "INSERT INTO categorie (libelle) VALUES (?) ";
	
	private static final String DELETE_UTILISATEUR = "DELETE FROM utilisateur (no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) WHERE no_utilisateur";
	
	private static final String DELETE_ARTICLEVENDU = "DELETE FROM articlevendu (no_article, nom, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, Utilisateur_no_utilisateur, Categorie_no_categeorie)WHERE ArticleVendu_no_article";
			
	private static final String UPDATE_UTILISATEUR = "UPDATE utilisateur SET (pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=?) WHERE no_utilisateur";

	private static final String UPDATE_ENCHERE = "UPDATE enchere SET (date_enchere=?, montant_enchere=?, Utilisateur_no_utilisateur=?, ArticleVendu_no_article=?) WHERE ArticleVendu_no_article";
	
	private static final String SELECT_UTILISATEUR= "SELECT utilisateur (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) WHERE no_utilisateur";
	
	private static final String SELECT_ARTICLEVENDU = "SELECT articlevendu (nom, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, Utilisateur_no_utilisateur, Categorie_no_categeorie) WHERE no_article";
	
	

	@Override
	public void insert_utilisateur(Utilisateur utilisateur) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert_articleVendu(ArticleVendu articleVendu) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert_enchere(Enchere enchere, Integer Utilisateur_no_utilisateur, Integer ArticleVendu_no_article) throws BusinessException {
		if(enchere==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, java.sql.Date.valueOf(enchere.getDate_enchere()));
			pstmt.setInt(2, enchere.getMontant_enchere());
			pstmt.setInt(3, Utilisateur_no_utilisateur);
			pstmt.setInt(4, ArticleVendu_no_article);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				enchere.setNo_enchere(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("CK_AVIS_note"))
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			}
			else
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}

	}

	@Override
	public void insert_retrait(Retrait retrait, Integer ArticleVendu_no_article) throws BusinessException {
		if(retrait==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, retrait.getRue());
			pstmt.setString(2, retrait.getCode_postal());
			pstmt.setString(3, retrait.getVille());
			pstmt.setInt(4, ArticleVendu_no_article);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("CK_AVIS_note"))
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			}
			else
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
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
				categorie.setNo_categorie(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("CK_AVIS_note"))
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			}
			else
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}
		
	}

	@Override
	public void delete_utilisateur(Utilisateur utilisateur) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete_articleVendu(ArticleVendu articleVendu) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete_enchere(Enchere enchere) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete_retrait(Retrait retrait) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update_utilisateur(Utilisateur utilisateur) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update_enchere(Enchere enchere) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void select_utilisateur(Utilisateur utilisateur) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void select_article(ArticleVendu articleVendu) throws BusinessException {
		// TODO Auto-generated method stub

	}


}
