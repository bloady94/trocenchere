package fr.eni.trocenchere.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.bo.Retrait;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.jdbc.EncheresDAOJdbcImpl;

/**
 * Servlet implementation class ServletTestJDBCImplInsert
 */
@WebServlet("/ServletTestJDBCImplInsert")
public class ServletTestJDBCImplInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestJDBCImplInsert() {
        super();
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur corentin = new Utilisateur("corentinLeCaramel","ROBIN", "Corentin", "jadoreJPP@gmail.com", "0612121212", "rue des Blasés", "35000", "RENNES", "motdepasse", 0, true);
		Utilisateur jeremie = new Utilisateur("jeremieLeBlase","DESNOES", "Jeremie", "jmePrendsDesBagnolesAVelo@gmail.com", "0606060606", "rue des Fifous", "35000", "RENNES", "1234", 100, true);
		Utilisateur gaspard = new Utilisateur("gazpacho","JOHANET", "Gaspard", "gaspardLeBG@crack.com", "0699999999", "rue des Quasi-Mineurs", "35000", "RENNES", "laMatrice", 100, false);
		
		Categorie electromenager = new Categorie("Electroménager");
		Categorie auto = new Categorie("Autos/Motos/Vélos");
		Categorie sport = new Categorie("Sport et Loisirs");
		
		ArticleVendu drogueDuBonheur = new ArticleVendu("LSD", "Petite pilule du bonheur :)", LocalDate.now(), LocalDate.of(2023, 3, 29), 100, 220, corentin,  electromenager);
		ArticleVendu veloDeCompet = new ArticleVendu("Velo", "B'Twin Decathlon", LocalDate.now(), LocalDate.of(2023, 4, 15), 100, 220, jeremie,  auto);
		ArticleVendu coeur5g = new ArticleVendu("Coeur 5 g", "C'est trop compliqué pour décrire", LocalDate.now(), LocalDate.of(2023, 4, 30), 100, 220, gaspard,  sport);
		
		Retrait retraitDrogue = new Retrait(corentin.getRue(), corentin.getCodePostal(), corentin.getVille(), drogueDuBonheur);
		Retrait retraitVelo = new Retrait(jeremie.getRue(), jeremie.getCodePostal(), jeremie.getVille(), veloDeCompet);
		Retrait retraitCoeur = new Retrait(gaspard.getRue(), gaspard.getCodePostal(), gaspard.getVille(), coeur5g);
		
		Enchere enchere1 = new Enchere(LocalDate.now(), 50, jeremie, drogueDuBonheur);
		Enchere enchere2 = new Enchere(LocalDate.now(), 60, corentin, coeur5g);
		Enchere enchere3 = new Enchere(LocalDate.now(), 100, gaspard, veloDeCompet);
		
		EncheresDAOJdbcImpl dao = new EncheresDAOJdbcImpl();
		
		try {
			dao.insert_utilisateur(jeremie);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
