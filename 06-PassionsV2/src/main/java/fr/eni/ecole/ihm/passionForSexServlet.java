package fr.eni.ecole.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class passionForSexServlet
 */
@WebServlet("/passionForSexServlet")
public class passionForSexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passionForSexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/passionForSex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PassionModel model = PassionModelSing.getInstance();
		
		if (request.getParameterValues("passion") != null) {
			String[] passionList = request.getParameterValues("passion");
			for (String passion : passionList) {
				model.getListPassion().add(passion);
			}
		} else {
			model.getListPassion().add("Vous n'avez pas de passion, sortez de chez vous toucher de l'herbe !");
		}
						
		// appel de l'écran
		request.setAttribute("model", model);
		
		request.getRequestDispatcher("/WEB-INF/summary.jsp").forward(request, response);
	}

}
