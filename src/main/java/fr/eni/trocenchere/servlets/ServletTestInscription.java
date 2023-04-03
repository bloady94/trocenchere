package fr.eni.trocenchere.servlets;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocenchere.bll.InscriptionManager;
import fr.eni.trocenchere.bll.singleton.InscriptionSing;
//import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletTestInscription
 */
@WebServlet("/ServletTestInscription")
public class ServletTestInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InscriptionSing inscriptionSing;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestInscription() {
    	inscriptionSing = new InscriptionSing();
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/inscription.jsp");
	    dispatcher.forward(request, response);
		
	}	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// R�cup�ration des param�tres 
		String pseudo = request.getParameter("pseudo");
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email= request.getParameter("email");
		String telephone= request.getParameter("telephone");
		String rue= request.getParameter("rue");
		String codePostal= request.getParameter("codePostal");
		String ville= request.getParameter("ville");
		String motDePasse= request.getParameter("motDePasse");
		String motDePasseConfirmation=request.getParameter("confirmationMDP");
		
	
		
		// Cr�ation d'un nouvel utilisateur
		Utilisateur user = new Utilisateur();
		
		// Cr�ation de dao de type ConnexionManager, On ins�re dedans l'instance de la singleton.
		InscriptionManager dao = inscriptionSing.getInstance();
		
		try {
			user = dao.ajouterUtilisateur1(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 100, false);
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		if (user !=null) {
		
			response.sendRedirect("/trocenchere/jsp/index.jsp");
			HttpSession session = request.getSession(true);
			session.setAttribute("utilisateur", user);
			
		}else{
			request.setAttribute("errorMessage", "Les mdp ne sont pas identiques");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/inscription.jsp");
		    dispatcher.forward(request, response);
			
		}

	}

}
