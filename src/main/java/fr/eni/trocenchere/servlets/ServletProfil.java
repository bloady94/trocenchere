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
import fr.eni.trocenchere.bll.ManagerFactory;
import fr.eni.trocenchere.bll.ProfilManager;
import fr.eni.trocenchere.bo.Utilisateur;

@WebServlet("/ServletProfil")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletProfil() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*try {
			ProfilManager profilManager = ManagerFactory.getProfilManager();
			Utilisateur utilisateur = profilManager.selectUtilisateurById(11);*/

			HttpSession session = request.getSession(true);
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			System.out.println(utilisateur);

			request.setAttribute("utilisateur", utilisateur);
			
		/*} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}*/
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/profil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
