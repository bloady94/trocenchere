package fr.eni.trocenchere.inscription;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletTestInscription
 */
@WebServlet("/ServletTestInscription")
public class ServletTestInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestInscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		if(request.getSession().getAttribute("isConnected")!=null) {
			rd=request.getRequestDispatcher("http://localhost:8080/trocenchere/jsp/index.jsp");
		}else {
			rd = request.getRequestDispatcher("/jsp/inscription.jsp");
		}
		rd.forward(request, response);
	}	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
		

		try {
			InscriptionManager IManager =  InscriptionManager.getInstance();
			Utilisateur utilisateurConnecte = IManager.ajouterUtilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse,motDePasseConfirmation);
			request.getSession().setAttribute("isConnected", utilisateurConnecte);
			request.setAttribute("connexion", "ok");
			
		} catch (Exception e) {
//			List<String> msgErr = new ArrayList<>();
//			
//			for(int i : ((BusinessException) e).getListeCodesErreur()) {
//				msgErr.add(LecteurMessage.getMessageErreur(i));
//			}
//			request.setAttribute("listeCodesErreur", msgErr);
//			rd=request.getRequestDispatcher("/jsp/inscription.jsp");
			e.printStackTrace();	
		}

		RequestDispatcher rd = request.getRequestDispatcher("http://localhost:8080/trocenchere/jsp/index.jsp");
		rd.forward(request, response);
	}
}
