package fr.eni.trocenchere.connexion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ConnexionManager connexionManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConnexion() {

		super();
		// On initialise la connexion à la base de données dans le constructeur de la
		// servlet
		connexionManager = new ConnexionManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

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

		// On appelle la méthode d'authentification de la classe ConnexionManager
		Utilisateur user;

		// On vérifie que les champs identifiant et mot de passe ne sont pas vides
		if (identifiant != null && motDePasse != null) {

			try {
				user = connexionManager.authentification(identifiant, motDePasse);

				// Si l'utilisateur existe dans la base de données
				if (user != null) {
					HttpSession session = request.getSession(true);

					// On stocke l'utilisateur en session pour qu'il soit accessible sur les autres
					// pages
					request.getSession().setAttribute("utilisateur", user);
					// On redirige l'utilisateur vers la page d'accueil par exemple
					response.sendRedirect("http://localhost:8080/trocenchere/jsp/index.jsp");
				} else {
					// Si l'utilisateur n'existe pas dans la base de données, on le redirige vers la
					// page de connexion avec un message d'erreur
					request.setAttribute("erreur", "Identifiant ou mot de passe incorrect");
					request.getRequestDispatcher("http://localhost:8080/trocenchere/jsp/connexion.jsp").forward(request,
							response);
				}

			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// Si les champs identifiant et mot de passe sont vides, on renvoie un message
			// d'erreur sur la page de connexion
			request.setAttribute("erreur", "Veuillez remplir tous les champs");
			request.getRequestDispatcher("connexion.jsp").forward(request, response);
		}

//	    response.setContentType("text/html;charset=UTF-8");
//	    PrintWriter out = response.getWriter();
//
//	    String pseudo = request.getParameter("identifiant");
//	    String mdp = request.getParameter("MotDePasse");
//
//	    try {
//	    	
//	       if (pseudo.equals(ConnexionDAO.))
//
//	        if (ConnexionManager.authentification(pseudo, mdp)) {
//
//	            HttpSession session = request.getSession(true);
//
//	            session.setAttribute("pseudo", pseudo);
//
//	            response.sendRedirect("http://localhost:8080/trocenchere/jsp/index.jsp");
//
//	        } else {
//	            out.println("Pseudo ou Mot de passe incorrect");
//	            RequestDispatcher rs = request.getRequestDispatcher("http://localhost:8080/trocenchere/jsp/connexion.jsp");
//	            rs.include(request, response);
//	        }
//	    } catch (BusinessException e) {
//	        // TODO Auto-generated catch block
//	        e.printStackTrace();
//	    }

	}
}