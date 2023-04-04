package fr.eni.trocenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocenchere.bll.InscriptionManager;
import fr.eni.trocenchere.bll.ModifierProfilManager;
import fr.eni.trocenchere.bll.singleton.ModifierSing;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModifierProfil() {
		super();
		// TODO Auto-generated constructor stub
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
		
		// R�cup�ration des param�tres du formulaire
		HttpSession session = request.getSession();
		
		// Je r�cup�re tous les param�tres du formulaire.
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasseActuel = request.getParameter("motDePasseActuel");
		String newMotDePasse = request.getParameter("motDePasse");
		String newMotDePasseConfirmation = request.getParameter("confirmationMDP");
		
		
		
		// Si le mot de passe correspond au MDP de l'utilisateur, alors v�rifier que le nouveau mdp correspond bien � la confirmation.

		
		
		
		// Si tout est bon, alors j'update les donn�es.
		
		
		
		
		/*
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		try {
			utilisateurManager.update(utilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasseActuel, nouveauMotDePasse);
			session.setAttribute("utilisateur", utilisateur);
			response.sendRedirect(request.getContextPath() + "/accueil");
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("listeErreurs", e.getListeCodesErreur());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
			dispatcher.forward(request, response);
		}
	}
	*/
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		// Je vais chopper une session
		HttpSession session = request.getSession(true);
		
		// Ensuite j'ins�re dans un utilisateur la session qu'on r�cup�re
		// dans la servletConnexion.
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		
		// On r�cup�re les param�tres du formulaire
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasseActuel = request.getParameter("motDePasseActuel");
		String newMotDePasse = request.getParameter("motDePasse");
		String newMotDePasseConfirmation = request.getParameter("confirmationMDP");

		
		ModifierProfilManager dao = ModifierSing.getInstance();

		try {
			utilisateur = dao.UpdateUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasseActuel);
		} catch (Exception e) {
			e.printStackTrace();

		}

		// Ensuite je demande le cr�dit de l'utilisateur, je nomme la clef "cr�dit"
		// que j'utiliserais dans la jsp
		request.setAttribute("credit", utilisateur.getCredit());

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/profil.jsp");
		rd.forward(request, response);
		*/


	}

}
