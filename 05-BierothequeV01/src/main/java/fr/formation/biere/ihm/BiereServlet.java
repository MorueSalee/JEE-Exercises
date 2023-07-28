package fr.formation.biere.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.biere.bll.AlcoolException;
import fr.formation.biere.bll.BiereManager;
import fr.formation.biere.bll.BiereManagerSing;
import fr.formation.biere.bo.Biere;
import fr.formation.biere.dal.DalException;

/**
 * Servlet implementation class BiereServlet
 */
@WebServlet("/BiereServlet")
public class BiereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BiereManager manager = BiereManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BiereServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("model", new BiereModel());
		request.getSession().setAttribute("modelPanier", new PanierModel());

		BiereModel model = (BiereModel) request.getSession().getAttribute("model");
		try {
			model.setLstBieres(manager.getAllBiere());
		} catch (DalException e) {
			model.setMessage(e.getMessage());
		} catch (AlcoolException e) {
			model.setMessage(e.getMessage());
		}

		// PanierModel modelPanier = (PanierModel)
		// request.getSession().getAttribute("modelPanier");

		// request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/biere.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("addList") != null) {
			BiereModel model = (BiereModel) request.getSession().getAttribute("model");

			Biere biere = new Biere(request.getParameter("nom"), request.getParameter("couleur"),
					request.getParameter("brasserie"), Double.parseDouble(request.getParameter("alcool")),
					request.getParameter("commentaire"), Integer.parseInt(request.getParameter("note")),
					Double.parseDouble(request.getParameter("prix")));
			try {
				manager.addBiere(biere);
			} catch (Exception e) {
				model.setMessage(e.getMessage());
			}

			model.setCurrent(biere);
			try {
				model.setLstBieres(manager.getAllBiere());
			} catch (DalException e) {
				model.setMessage(e.getMessage());
			} catch (AlcoolException e) {
				model.setMessage(e.getMessage());
			}

			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/biere.jsp").forward(request, response);

		} else if (request.getParameter("addCart") != null) {
			BiereModel modelBiere = (BiereModel) request.getSession().getAttribute("model");
			PanierModel modelPanier = (PanierModel) request.getSession().getAttribute("modelPanier");

			modelBiere.setMessage("Vos articles ont bien été ajoutés !");

			String[] bierePanierList = request.getParameterValues("panier");

			for (String biereId : bierePanierList) {
				for (Biere biere : modelBiere.getLstBieres()) {
					if (biere.getId() == Integer.parseInt(biereId)) {
						modelPanier.getLstBieres().add(biere);
					}
				}
			}

			request.setAttribute("modelPanier", modelPanier);
			request.getRequestDispatcher("/WEB-INF/biere.jsp").forward(request, response);

		} else if (request.getParameter("getCart") != null) {
			BiereModel model = (BiereModel) request.getSession().getAttribute("model");
			model.setMessage("");

			request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);

		} else if (request.getParameter("getHome") != null) {
			request.getRequestDispatcher("/WEB-INF/biere.jsp").forward(request, response);
		}
	}

}
