package fr.eni.ecole.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.bo.Person;

/**
 * Servlet implementation class IdentityServlet
 */
@WebServlet("/IdentityServlet")
public class IdentityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdentityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/identity.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupération des données
		PassionModel model = PassionModelSing.getInstance();
		Person person = new Person();
		person.setName(request.getParameter("name"));
		person.setSurname(request.getParameter("surname"));
		person.setSex(request.getParameter("sex"));
		
		// reconstitution du modèle 
		model.setCurrent(person);

		// appel de l'écran
		request.setAttribute("model", model);
		
		request.getRequestDispatcher("/WEB-INF/passionForSex.jsp").forward(request, response);
	}

}
