package fr.eni.ecole.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.bll.BllException;
import fr.eni.ecole.bll.DateFormatter;
import fr.eni.ecole.bll.TaskManager;
import fr.eni.ecole.bll.TaskManagerSing;
import fr.eni.ecole.bo.Task;
import fr.eni.ecole.dal.DalException;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskManager manager = TaskManagerSing.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskModel model = new TaskModel();
		
		try {
			model.setTaskList(manager.getTaskNotDone());
		} catch (DalException e) {
			model.setMessage(e.getMessage());
		} catch (ClassNotFoundException e) {
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
		TaskModel model = (TaskModel) request.getSession().getAttribute("model");
		model.setMessage("");
		// récupération des données
		Task task = new Task();
		
		task.setLabel(request.getParameter("label"));
		task.setDtStart(DateFormatter.stringToDate(request.getParameter("dtStart")));
		task.setDtEnd(DateFormatter.stringToDate(request.getParameter("dtEnd")));
		task.sethStart(DateFormatter.stringToTime(request.getParameter("hStart")));
		task.sethEnd(DateFormatter.stringToTime(request.getParameter("hEnd")));
		task.setPriority(Integer.parseInt(request.getParameter("priority")));
		task.setIsDone(Boolean.parseBoolean(request.getParameter("isDone")));
		
		// appel au métier
		//if (request.getParameter("BT1") != null) {
			try {
				manager.addTask(task);
			} catch (DalException e) {
				model.setMessage(e.getMessage());
			} catch (ClassNotFoundException e) {
				model.setMessage(model.getMessage() + "<br>" + e.getMessage());
			} catch (BllException e) {
				model.setMessage(model.getMessage() + "<br>" + e.getMessage());
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
		model.setCurrent(task);
		try {
			model.setTaskList(manager.getTaskNotDone());
		} catch (DalException e) {
			model.setMessage(e.getMessage());
		} catch (ClassNotFoundException e) {
			model.setMessage(model.getMessage() + "<br>" + e.getMessage());
		}

		// appel de l'écran
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

}
