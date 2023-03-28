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
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.EncheresDAOJdbcImpl;

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
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur corentin = new Utilisateur("corentinLeCaramel","ROBIN", "Corentin", "jadoreJPP@gmail.com", "0612121212", "rue des Blasés", "35000", "RENNES", "motdepasse", 0, true);
		EncheresDAOJdbcImpl dao = new EncheresDAOJdbcImpl();
//		System.out.println(corentin);
//		try {
//			dao.insert_utilisateur(corentin);
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		EncheresDAOJdbcImpl dao2 = new EncheresDAOJdbcImpl();
//		
		Categorie electromenager = new Categorie("Electroménager");
		Categorie auto = new Categorie("Autos/Motos/Vélos");
		Categorie jardinage = new Categorie("Jardinage");
		Categorie jouet = new Categorie("Jouets");
		Categorie vetement = new Categorie("Vêtements");
//		
//		
//		System.out.println(electromenager);
//		try {
//			dao2.insert_categorie(vetement);
//			dao2.insert_categorie(electromenager);
//			dao2.insert_categorie(auto);
//			dao2.insert_categorie(jardinage);
//			dao2.insert_categorie(jouet);
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		EncheresDAOJdbcImpl dao3 = new EncheresDAOJdbcImpl();
		ArticleVendu drogueDuBonheur = new ArticleVendu("LSD", "Petite pilule du bonheur :)", LocalDate.now(), LocalDate.of(2023, 3, 29), 100, 220);
		System.out.println(drogueDuBonheur);
		
		try {
			dao3.insert_articleVendu(drogueDuBonheur, corentin.getNo_utilisateur(), jouet.getNo_categorie());
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
