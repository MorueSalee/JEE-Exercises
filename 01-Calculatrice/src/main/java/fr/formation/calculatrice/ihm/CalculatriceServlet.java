package fr.formation.calculatrice.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatriceServlet
 */
@WebServlet("/CalculatriceServlet")
public class CalculatriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatriceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// LA PREMIERE FOIS (PREMIER APPEL)
		request.getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// VERIFICATION ET CONVERSION
		Integer a = Integer.parseInt(request.getParameter("a"));
		Integer b = Integer.parseInt(request.getParameter("b"));
		
		// TRAITEMENT
		Integer res = a+b;
		
		// APPEL DE LA VUE
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.setAttribute("resultat", res);
		request.getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
	}

}
