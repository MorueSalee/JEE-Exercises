package fr.eni.ecole.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.bll.BllException;
import fr.eni.ecole.bll.Manager;
import fr.eni.ecole.bll.ManagerSing;
import fr.eni.ecole.bo.User;
import fr.eni.ecole.dal.DalException;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Manager manager = ManagerSing.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model = new Model();
		
		try {
			model.setTaskList(manager.getAllUser());
		} catch (DalException e) {
			model.setMessage(model.getMessage() + "<br>" + e.getMessage());
		} catch (ClassNotFoundException e) {
			model.setMessage(model.getMessage() + "<br>" + e.getMessage());
		} catch (BllException e) {
			model.setMessage(model.getMessage() + "<br>" + e.getMessage());
		}
		
		request.getSession().setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// initialisation du modèle
		Model model = (Model) request.getSession().getAttribute("model");
		model.setMessage("");
		
		// appel au métier
		if (request.getParameter("goToHome") != null) {
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		}
		
		if (request.getParameter("goToLogin") != null) {
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		
		if (request.getParameter("goToSignin") != null) {
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
		}
		
		if (request.getParameter("loginButton") != null) {			
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			try {
				if (manager.checkUser(login, password) != null) {
					model.setMessage("Login successful !");
					request.getSession().setAttribute("user", manager.checkUser(login, password));
					
					request.setAttribute("model", model);
					request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

				} else {
					model.setMessage("Login failed !");
					
					request.setAttribute("model", model);
					request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
				}
				
			} catch (ClassNotFoundException | DalException | BllException e) {
				model.setMessage(model.getMessage() + "<br>" + e.getMessage());
			}
			
		}
		
		if (request.getParameter("signinButton") != null) {
			User user = new User(
					request.getParameter("name"),
					request.getParameter("firstName"),
					request.getParameter("login"),
					request.getParameter("password")
					);
			
			try {
				manager.addUser(user);
				model.setMessage("Account created !");
				
				request.setAttribute("model", model);
				request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
			} catch (DalException e) {
				model.setMessage(model.getMessage() + "<br>" + e.getMessage());
			} catch (ClassNotFoundException e) {
				model.setMessage(model.getMessage() + "<br>" + e.getMessage());
			} catch (BllException e) {
				model.setMessage(model.getMessage() + "<br>" + e.getMessage());
			}
			
		}
	}

}
