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
import fr.eni.trocenchere.bll.InscriptionManager;
import fr.eni.trocenchere.bll.ModifierProfilManager;
import fr.eni.trocenchere.bll.singleton.ConnexionSing;
import fr.eni.trocenchere.bll.singleton.ModifierSing;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModifierSing modifierSing;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModifierProfil() {
		modifierSing = new ModifierSing();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/modifierProfil.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		session.getAttribute("utilisateur"); // manque utilisateur à rajouter en paramètre

		
		
		// Récupération des paramètres du formulaire
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasseActuel = request.getParameter("motDePasseActuel");
		String nouveauMDP = request.getParameter("nouveauMDP");
		String confirmationMDP = request.getParameter("confirmationMDP");
		
		
		// J'envoie les paramètres récup dans la bll pour faire les vérifications et l'update
		
		// Ma méthode updateUtilisateur a un utilisateur en paramètre donc création d'un user et on met dedans tous les paramètres du formulaire.
		Utilisateur user = new Utilisateur(pseudo,nom, prenom, email, telephone, rue, codePostal, ville, motDePasseActuel, nouveauMDP);
		
		
		ModifierProfilManager dao = modifierSing.getInstance();

		
		// Il faut que je trouve un moyen d'envoyer user et les paramètres à la bll
		try {
			user = dao.UpdateUtilisateur(user, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasseActuel, nouveauMDP);
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
