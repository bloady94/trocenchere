package fr.eni.trocenchere.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import fr.eni.trocenchere.bll.ArticleManager;
import fr.eni.trocenchere.bll.CategorieManager;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.bo.Utilisateur;


/**
 * Servlet implementation class ServletAjoutArticle
 */
@WebServlet("/ServletAjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String ARTICLE_A_MANIPULER = "articleAManipuler";
	private static final String LIST_CATEGORIE = "listCategorie";
	private static final String UTILISATEUR = "Utilisateur";

	//private static CategorieManager categorieManager = CategorieManagerSing.getInstanceCategorieImpl();
	//private static Utilisateur utilisateurManager = UtilistateurManagerSing.getInstanceUtilisateur(); 
	//private static ArticleManager articleManager = ArticleManagerSing.getInstanceArticle(); 
	//private static RetraitManager retraitManager = RetraitManagerSing.getInstanceRetraitImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutArticle() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	
		HttpSession session = request.getSession(); 
		Integer NoUtilisateur = (Integer) session.getAttribute("id");
		
		
		 Utilisateur utilisateur = new Utilisateur();
	      utilisateur.setNoUtilisateur(1);
	      
	    // récupère la liste des categorie => select libelle from categorie
	      List<Categorie> ListCategorie = new ArrayList<>();
	      
	      if(NoUtilisateur == null) {
	    	  response.sendRedirect("ServletConnexion");
	      }
	      else { 
	    	  try { ListCategorie = CategorieManager.selectArticles(); 
	      request.setAttribute(LIST_CATEGORIE, ListCategorie); 
	      
	      NoUtilisateur = (Integer) request.getSession().getAttribute("id"); 
	      utilisateur.setNoUtilisateur(NoUtilisateur); 
	      request.setAttribute(UTILISATEUR, utilisateur); } catch (Exception e1) { e1.printStackTrace(); }
	      }
	      
		//=> setattribute List<Categorie>
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp"); rd.forward(request, response);
		
	}

	/**
	 * @param FinEnchere 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, ChronoLocalDate FinEnchere) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		
		ArticleManager articleManager = null;
		
	//	String nomArticle = null;
	//	String description = null;
	//	Integer noCategorie = null;
	//	LocalDate dateDebutEnchere = null;
	//	LocalDate dateFinEnchere = null;
	//	Integer prixInitial = null;
	//	String rue = null;
	//	String codePostal = null;
	//	String nomVille = null;
	//	Categorie categorie = null;
	//	Retrait retrait=null;
	//	Integer noUtilisateur;
	//	Utilisateur utilisateur = new Utilisateur();
	//	ArticleVendu articleVendu = null;
	//	Integer resultatComparaisonDates = null;
	//	List<Integer> listeCodesErreur = new ArrayList<>();
	//	String photo = null;
		
		
		
		
		String nom = request.getParameter("nomArticle");
        String description = request.getParameter("description");
        String photo = request.getParameter("photo");
        Integer prixInitial = Integer.parseInt(request.getParameter("prix initial"));
        Integer prixFinal = Integer.parseInt(request.getParameter("prix final"));
        LocalDate debutEnchere = LocalDate.parse(request.getParameter("debutEnchere"));
        LocalDate finEnchere = LocalDate.parse(request.getParameter("finEnchere"));
        
        Enchere enchere = new Enchere();
        
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        
      //  ArticleVendu art = request.getParameter(" NoArticle");
        
       // Retrait retrait = new Retrait(rue, codePostal, ville, art);
        		
        String categorie = request.getParameter("categorie");
        
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setNoUtilisateur(1);
        
      //  Categorie categorie1 = new Categorie();
       // categorie.setNoCategorie(1);

      /*  System.out.println(request.getParameter("imageArticle"));
        String test = request.getParameter("imageArticle");
        Boolean photoOuPas= true;
        
     if (test.equals("")) { 
        	photoOuPas = false; }
        
        
		ArticleVendu article = new ArticleVendu(nom, description, debutEnchere, 
								finEnchere, prixInitial, utilisateur1, categorie, retrait);
        System.out.println("articleManager" + article);
        
        if (photoOuPas) { photo = request.getParameter("imageArticle");
        ArticleVendu.setPhoto(photo);
        
        ArticleVendu article1 = new ArticleVendu(nom, description, debutEnchere, 
				finEnchere, prixInitial, utilisateur1, categorie, retrait);
        
        }
        retrait = new Retrait(rue,codePostal,ville);
       resultatComparaisonDates = debutEnchere.compareTo(FinEnchere); 
        
       if(resultatComparaisonDates > 0) {
        }
        la date de début est postérieure à la date de fin listeCodesErreur.add(CodesResultatServlets.ERREUR_DATE_POSTERIEUR); request.setAttribute("listeCodesErreur", listeCodesErreur);
        
       listeCodesErreur.add(CodesResultatServlets.ERREUR_DATE_POSTERIEUR);
       request.setAttribute("listeCodesErreur", listeCodesErreur);
         if (resultatComparaisonDates == 0) 
       { 
        	 les deux dates sont égales listeCodesErreur.add(CodesResultatServlets.ERREUR_DATES_IDENTIQUES); request.setAttribute("listeCodesErreur", listeCodesErreur); }else if(resultatComparaisonDates < 0){ // la date de début est antérieure à la date de fin // appel à la BLL pour ajouter Article + Retrait articleVenduManager.ajouterArticleVendu(articleVendu); retraitManager.ajouterRetrait(retrait); request.setAttribute("articleAManipuler", articleVendu); // permettre d'instancier un attribut dans la session pour le recuperer// dans une autre Servlet session.setAttribute(ARTICLE_A_MANIPULER, articleVendu); } } catch (Exception e) { e.printStackTrace(); }
        	 }*/
	
	
        doGet(request, response);
       		
	}
	

}



	



