package fr.eni.ecole.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.bll.SweetManager;
import fr.eni.ecole.bll.SweetManagerSing;
import fr.eni.ecole.bo.Sweet;
import fr.eni.ecole.dal.DalException;

/**
 * Servlet implementation class SweetServlet
 */
@WebServlet("/SweetServlet")
public class SweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SweetManager manager = SweetManagerSing.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SweetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SweetModel model = new SweetModel();
		
		try {
			model.setSweetList(manager.getAllSweet());
		} catch (DalException e) {
			model.setMessage(e.getMessage());
		} catch (ClassNotFoundException e) {
			model.setMessage(model.getMessage() + "********" + e.getMessage());
		}

		request.getSession().setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// initialisation du modèle
		SweetModel model = (SweetModel) request.getSession().getAttribute("model");
		
		// récupération des données
		Sweet sweet = new Sweet();
		sweet.setName(request.getParameter("name"));
		sweet.setDescription(request.getParameter("description"));
		sweet.setTaste(request.getParameter("taste"));
		sweet.setPrice(Float.parseFloat(request.getParameter("price")));
		sweet.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		// appel au métier
		//if (request.getParameter("BT1") != null) {
			try {
				manager.addSweet(sweet);
			} catch (DalException e) {
				model.setMessage(e.getMessage());
			} catch (ClassNotFoundException e) {
				model.setMessage(model.getMessage() + "<br>" + e.getMessage());
				System.out.println("fdgfdg");
			}
		//}
		/*if (request.getParameter("BT2") != null) {
			try {
				manager.updateSweet(sweet);
			} catch (DalException e) {
				model.setMessage(e.getMessage());
			} catch (ClassNotFoundException e) {
				model.setMessage(model.getMessage() + "********" + e.getMessage());
			}
		}*/
		
		// reconstitution du modèle 
		model.setCurrent(sweet);
		try {
			model.setSweetList(manager.getAllSweet());
		} catch (DalException e) {
			model.setMessage(e.getMessage());
		} catch (ClassNotFoundException e) {
			model.setMessage(model.getMessage() + "********" + e.getMessage());
		}

		// appel de l'écran
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

}
