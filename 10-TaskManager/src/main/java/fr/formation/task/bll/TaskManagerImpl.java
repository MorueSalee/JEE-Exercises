package fr.formation.task.bll;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import fr.formation.task.bo.Task;
import fr.formation.task.dal.DALException;
import fr.formation.task.dal.DAOFact;
import fr.formation.task.dal.TaskDAO;

public class TaskManagerImpl implements TaskManager {
	private TaskDAO dao = DAOFact.getTaskDAO();

	@Override
	public void addTask(Task task) throws TaskException {
		if(task.getEnd().isBefore(task.getStart())) {
			throw new TaskException("ms_upsidedown");
		}
		if(task.getEnd().isBefore(LocalDateTime.now())) {
			throw new TaskException("ms_endfuture");
		}
		if(task.getStart().isBefore(LocalDateTime.now())) {
			throw new TaskException("ms_startfuture");
		}
		try {
			dao.insert(task);
		} catch (DALException e) {
			throw new TaskException("ms_add");
		}
	}

	@Override
	public List<Task> getAllTasksToDo() throws TaskException {
		try {
			return dao.getAll().stream()
					.filter(t->!t.getIsDone())
					.sorted(Comparator.comparingInt(Task::getPriority))
					.toList();
		} catch (DALException e) {
			throw new TaskException("ms_getall");
		}
	}

}
