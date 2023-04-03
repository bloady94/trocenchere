package fr.eni.trocenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bll.ConnexionManager;
import fr.eni.trocenchere.bll.ConnexionSing;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ConnexionSing connexionSing;


	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConnexion() {
		connexionSing = new ConnexionSing();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/connexion.jsp");
	    dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 

		// On récupère les données entrées par l'utilisateur dans la page JSP
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("MotDePasse");
		
		Utilisateur user = new Utilisateur();
		
		user.setEmail(identifiant); 
		user.setPseudo(identifiant);
		user.setMotDePasse(motDePasse);

		
		// Création de dao de type ConnexionManager, On insère dedans l'instance de la singleton.
		ConnexionManager dao = connexionSing.getInstance();
		
		try {
			user = dao.authentification(identifiant, motDePasse);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (user !=null) {
			response.sendRedirect("/trocenchere/jsp/index.jsp");
			HttpSession session = request.getSession(true);
			session.setAttribute("utilisateur", user);
			
		}else {
			request.setAttribute("errorMessage", "Identifiant ou mot de passe incorrect.");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/connexion.jsp");
		    dispatcher.forward(request, response);
			
		}
	}
}