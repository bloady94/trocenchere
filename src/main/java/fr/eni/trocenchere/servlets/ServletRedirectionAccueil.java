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

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bll.ArticleManager;
import fr.eni.trocenchere.bo.ArticleVendu;

/**
 * Servlet implementation class ServletRedirectionAccueil
 */
@WebServlet("/ServletRedirectionAccueil")
public class ServletRedirectionAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRedirectionAccueil() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
        
        // Invoquez la méthode forward() de RequestDispatcher pour exécuter votre JSP
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
