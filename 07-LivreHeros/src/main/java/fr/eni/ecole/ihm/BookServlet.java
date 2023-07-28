package fr.eni.ecole.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.bll.BookManager;
import fr.eni.ecole.bll.BookManagerSing;
import fr.eni.ecole.bo.Page;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookManager manager = BookManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("page", manager.getPage(0));
		Page currentPage = (Page) request.getAttribute("page");

		BookModel model = new BookModel();

		model.setMessage("");

		// Contrôle de duplication d'un objet
		if (currentPage.getObject() != null) {
			for (String object : model.getInventory()) {
				if (object == currentPage.getObject()) {
					model.setMessage("Vous possèdez déjà cet objet !");
				}
			}

			// Ajout de l'objet dans l'inventaire s'il n'est pas présent
			if (model.getMessage().equals("")) {
				model.getInventory().add(currentPage.getObject());
			}
		}

		request.getSession().setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/story.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page currentPage = manager.getPage(Integer.parseInt(request.getParameter("pageNumber")) - 1);
		BookModel model = (BookModel) request.getSession().getAttribute("model");

		model.setMessage("");

		// Clear l'inventaire lors du retour sur la premiere page
		if (currentPage.getPageNumber() == 1) {
			model.getInventory().clear();
		}

		// Clear l'inventaire lors du retour sur la premiere page
		if (currentPage.getPageNumber() == 3) {
			
			currentPage.getPageList().remove(manager.getPage(12));
			currentPage.getPageList().remove(manager.getPage(3));
			
			if(model.getInventory().contains("Rubis Rouge")){
				currentPage.getPageList().add(manager.getPage(12));
			} else {
				currentPage.getPageList().add(manager.getPage(3));
			}
		}

		// Clear l'inventaire si la page contient un voleur
		if (currentPage.getThief()) {
			model.getInventory().clear();
			model.setMessage("Le voleur vous dépouille de tous vos effets personels !");
		} else {
			model.setMessage("");
			// Contrôle de duplication d'un objet
			if (currentPage.getObject() != null) {
				for (String object : model.getInventory()) {
					if (object == currentPage.getObject()) {
						model.setMessage("Vous possèdez déjà cet objet !");
					}
				}

				// Ajout de l'objet dans l'inventaire s'il n'est pas présent
				if (model.getMessage().equals("")) {
					model.getInventory().add(currentPage.getObject());
				}
			}
		}

		request.getSession().setAttribute("model", model);
		request.setAttribute("page", manager.getPage(Integer.parseInt(request.getParameter("pageNumber")) - 1));
		request.getRequestDispatcher("/WEB-INF/story.jsp").forward(request, response);
	}

}
