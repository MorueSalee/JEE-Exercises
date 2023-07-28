package fr.eni.ecole.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgeVoteServlet
 */
@WebServlet("/AgeVoteServlet")
public class AgeVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgeVoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ageVote.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// VERIFICATION ET CONVERSION
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String nationalite = request.getParameter("nationalite");
		String resultat = "Félicitations " + prenom + " " + nom + ", allez voter (à gauche)!";
		
		// TRAITEMENT
		if(age < 18 || !nationalite.equals("Français")) {
			resultat = "Vous ne pouvez pas voter ! Grandis un peu" + prenom + " " + nom + "!";
		}
		
		// APPEL DE LA VUE
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("age", age);
		request.setAttribute("nationalite", nationalite);
		request.setAttribute("resultat", resultat);
		request.getRequestDispatcher("/WEB-INF/ageVote.jsp").forward(request, response);
	}

}
