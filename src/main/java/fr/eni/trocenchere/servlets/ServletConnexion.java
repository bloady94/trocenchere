package fr.eni.trocenchere.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bll.ArticleManager;
import fr.eni.trocenchere.bll.ConnexionManager;
import fr.eni.trocenchere.bll.ProfilManagerImpl;
import fr.eni.trocenchere.bll.singleton.ConnexionSing;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConnexion() {
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/connexion.jsp");
	    dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 

		List<Integer> listeCodesErreur=new ArrayList<>();

		if(listeCodesErreur.size()>0)
		{
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		}
		else
		{
			try {
				ArticleManager articleManager = new ArticleManager();
				List<ArticleVendu> listeArticles=new ArrayList<>();

				listeArticles.addAll(articleManager.selectionnerTousLesArticles());

				request.setAttribute("listeArticles", listeArticles);
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
			}
		}
		
		// On récupère les données entrées par l'utilisateur dans la page JSP
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("MotDePasse");
		
		
		Utilisateur user = new Utilisateur();
		
		
		user.setEmail(identifiant); 
		user.setPseudo(identifiant);
		user.setMotDePasse(motDePasse);

		
		// Création de dao de type ConnexionManager, On insère dedans l'instance de la singleton.
		ConnexionManager dao = ConnexionSing.getInstance();
		ProfilManagerImpl dao2 = new ProfilManagerImpl();
		
		
		try {
			user = dao.authentification(identifiant, motDePasse);
			user = dao2.selectUtilisateurByMDP(motDePasse);

			
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		
		if (user !=null) {
			//response.sendRedirect("/trocenchere/jsp/index.jsp");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/index.jsp");
			HttpSession session = request.getSession(true);
			session.setAttribute("utilisateur", user);
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("errorMessage", "Identifiant ou mot de passe incorrect.");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/connexion.jsp");
		    dispatcher.forward(request, response);
			
		}
	}
}