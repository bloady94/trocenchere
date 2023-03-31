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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConnexion() {
		super();
		// TODO Auto-generated constructor stub
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


	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    // obtenir la session courante (si elle existe)

	    String pseudo = request.getParameter("identifiant");
	    String mdp = request.getParameter("MotDePasse");

	    try {
	    	ConnexionDAO dao = new ConnexionDAO();	        

	        if (dao.verificationPseudo(pseudo, mdp)) {

	            HttpSession session = request.getSession(true);

	            session.setAttribute("pseudo", pseudo);

	            response.sendRedirect("http://localhost:8080/trocenchere/jsp/index.jsp");

	        } else {
	            out.println("Pseudo ou Mot de passe incorrect");
	            RequestDispatcher rs = request.getRequestDispatcher("http://localhost:8080/trocenchere/jsp/connexion.jsp");
	            rs.include(request, response);
	        }
	    } catch (BusinessException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	}
}