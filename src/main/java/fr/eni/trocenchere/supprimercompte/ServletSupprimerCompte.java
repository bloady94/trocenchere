package fr.eni.trocenchere.supprimercompte;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocenchere.BusinessException;

/**
 * Servlet implementation class ServletSupprimerCompte
 */
@WebServlet("/ServletSupprimerCompte")
public class ServletSupprimerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupprimerCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			    String noUtilisateur = request.getParameter("noUtilisateur");

			    Connection connection = null;
			    PreparedStatement statement = null;
			    ResultSet resultSet = null;

			    try {
			      Class.forName("com.mysql.jdbc.Driver");
			      connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

			      // Vérifier que l'utilisateur existe avant de supprimer son profil
			      String sqlSelect = "SELECT * FROM utilisateurs WHERE id = ?";
			      statement = connection.prepareStatement(sqlSelect);
			      statement.setInt(1, Integer.parseInt(noUtilisateur));
			      resultSet = statement.executeQuery();

			      if (resultSet.next()) {
			        // L'utilisateur existe, supprimer son profil
			        String sqlDelete = "DELETE FROM profils WHERE idUtilisateur = ?";
			        statement = connection.prepareStatement(sqlDelete);
			        statement.setInt(1, Integer.parseInt(noUtilisateur));
			        statement.executeUpdate();
			      }

			      response.sendRedirect(request.getContextPath() + "/trocenchere/src/main/webapp/jsp/supprimerCompte.jsp");
			    } catch (BusinessException | SQLException e) {
			      e.printStackTrace();
			    } finally {
			      try {
			        if (resultSet != null) {
			          resultSet.close();
			        }
			        if (statement != null) {
			          statement.close();
			        }
			        if (connection != null) {
			          connection.close();
			        }
			      } catch (Exception e) {
			        e.printStackTrace();
			      }
			    }
			  }

	}

