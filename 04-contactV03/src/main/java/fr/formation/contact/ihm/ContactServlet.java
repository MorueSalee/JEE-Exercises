package fr.formation.contact.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.contact.bll.ContactManager;
import fr.formation.contact.bll.ContactManagerSing;
import fr.formation.contact.bo.Contact;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactManager manager = ContactManagerSing.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// initialisation du modèle
		ContactModel model = new ContactModel();
		model.setLstContacts(manager.getAllContact());

		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/contact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// initialisation du modèle
		ContactModel model = new ContactModel();
		
		// récupération des données
		Contact contact = new Contact();
		contact.setNom(request.getParameter("nom"));
		contact.setPrenom(request.getParameter("prenom"));
		contact.setTel(request.getParameter("tel"));
		
		// appel au métier
		manager.addContact(contact);
		
		// reconstitution du modèle 
		model.setCurrent(contact);
		model.setLstContacts(manager.getAllContact());

		// appel de l'écran
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/contact.jsp").forward(request, response);
	}

}
