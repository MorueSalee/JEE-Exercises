package fr.eni.ecole.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.ecole.bo.Task;
import fr.eni.ecole.dal.DalException;
import fr.eni.ecole.dal.TaskDAO;
import fr.eni.ecole.dal.TaskDAOFact;

public class TaskManagerImpl implements TaskManager {
	private TaskDAO dao = TaskDAOFact.getTaskDAO();

	@Override
	public void addTask(Task task) throws ClassNotFoundException, DalException, BllException {
		LocalDate nowDate = LocalDate.now();
		if (task.getDtStart().compareTo(task.getDtEnd()) >= 0) {
			throw new BllException("Ending date must be superior than starting date !");
		}else {
			if (task.getDtStart().compareTo(nowDate) <= 0) {
				throw new BllException("Starting date can't start in the past !");
			} else {
				dao.insert(task);
			}
		}
		
	}

	@Override
	public List<Task> getAllTask() throws ClassNotFoundException, DalException {
		return dao.selectAll();
	}
	
	@Override
	public List<Task> getTaskNotDone() throws ClassNotFoundException, DalException {
		return dao.selectAllNotDoneOrderedByPriority();
	}

}
