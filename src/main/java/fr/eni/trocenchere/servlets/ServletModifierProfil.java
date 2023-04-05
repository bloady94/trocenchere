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
import fr.eni.trocenchere.bll.singleton.ModifierProfilManagerSingl;
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

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		request.setAttribute("utilisateur", utilisateur);
		
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
		
		session.getAttribute("utilisateur"); // manque utilisateur � rajouter en param�tre
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		// R�cup�ration des param�tres du formulaire
		utilisateur.setPseudo(request.getParameter("pseudo"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setEmail(request.getParameter("email"));
		utilisateur.setTelephone(request.getParameter("telephone"));
		utilisateur.setRue(request.getParameter("telephone"));
		



		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		//TODO attention gestion diff�rente
		String motDePasseActuel = request.getParameter("motDePasseActuel");
		String nouveauMDP = request.getParameter("nouveauMDP");
		String confirmationMDP = request.getParameter("confirmationMDP");

		// J'envoie les param�tres r�cup dans la bll pour faire les v�rifications et
		// l'update

		// Ma m�thode updateUtilisateur a un utilisateur en param�tre donc cr�ation d'un
		// user et on met dedans tous les param�tres du formulaire.
		Utilisateur user = new Utilisateur(utilisateur.getNoUtilisateur(),pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasseActuel);

		

		// Il faut que je trouve un moyen d'envoyer user et les param�tres � la bll
		try {
			ModifierProfilManager managerProfil = ModifierProfilManagerSingl.getInstance();
			managerProfil.UpdateUtilisateur(utilisateur, nouveauMDP);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (user == null) {
			request.setAttribute("errorMessage", "probl�me, c'est tout ce que je vais te dire car pas d'inspi...");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/modifierProfil.jsp");
		dispatcher.forward(request, response);

	}

}
