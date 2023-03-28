package fr.eni.trocenchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocenchere.BusinessException;
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
		System.out.println(corentin);
		try {
			dao.insert_utilisateur(corentin);
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
