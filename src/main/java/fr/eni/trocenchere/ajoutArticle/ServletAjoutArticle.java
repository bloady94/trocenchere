package fr.eni.trocenchere.ajoutArticle;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocenchere.bo.ArticleVendu;




/**
 * Servlet implementation class ServletAjoutArticle
 */
@WebServlet("/ServletAjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ajoutArticle.jsp"); rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		ArticleManager articleManager = new ArticleManager();
        ArticleVendu article1 = null;
		
		String article = request.getParameter("nomArticle");
        String description = request.getParameter("description");
        String categorie = request.getParameter("categorie");
        String photo = request.getParameter("photo");
        int miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
        LocalDate debutEnchere = LocalDate.parse(request.getParameter("debutEnchere"));
        LocalDate finEnchere = LocalDate.parse(request.getParameter("finEnchere"));
        String rue = request.getParameter("rue");
        int codePostal = Integer.parseInt(request.getParameter("codePostal"));
        String ville = request.getParameter("ville");
        
        this.getServletContext().getRequestDispatcher("/jsp/ajoutArticle.jsp").forward(request, response);
        
        
	}

}
