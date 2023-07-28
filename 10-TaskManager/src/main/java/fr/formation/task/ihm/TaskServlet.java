package fr.formation.task.ihm;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.task.bll.TaskException;
import fr.formation.task.bll.TaskManager;
import fr.formation.task.bll.TaskManagerSing;
import fr.formation.task.bo.Task;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskManager manager = TaskManagerSing.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Locale.setDefault(request.getLocale());
		ResourceBundle bundle = ResourceBundle.getBundle("fr.formation.task.bundles.message", request.getLocale());
		TaskModel model = new TaskModel();
		try {
			model.setLstTasks(manager.getAllTasksToDo());
		} catch (TaskException e) {
			model.setMessage(bundle.getString(e.getMessage()));
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/task.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Locale.setDefault(request.getLocale());
		ResourceBundle bundle = ResourceBundle.getBundle("fr.formation.task.bundles.message", request.getLocale());
		Task task = new Task();
		
		String message = "";
		
		// add a task
		if (request.getParameter("BT_ADD") != null) {
			task = new Task(request.getParameter("label"), LocalDateTime.parse(request.getParameter("start")),
					LocalDateTime.parse(request.getParameter("end")),
					Integer.parseInt(request.getParameter("priority")), false);
			
			try {
				manager.addTask(task);
			} catch (TaskException e) {
				message = bundle.getString(e.getMessage());
			}
		}
		
		
		List<Task> lstTasks = new ArrayList<>();
		try {
			lstTasks = manager.getAllTasksToDo();
		} catch (TaskException e) {
			message = bundle.getString(e.getMessage());
		}
		TaskModel model = new TaskModel(message, task, lstTasks);

		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/task.jsp").forward(request, response);
	}

}
