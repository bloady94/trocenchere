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
 * Servlet implementation class InitJspServlet
 */
@WebServlet(urlPatterns = "", name = "InitJspServlet", loadOnStartup = 1)

public class InitJspServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
    public InitJspServlet() {
    }

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
	
        // Créez une instance de RequestDispatcher pour votre JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
        
        // Invoquez la méthode forward() de RequestDispatcher pour exécuter votre JSP
        dispatcher.forward(request, response);
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	doGet(request, response);
}
}


