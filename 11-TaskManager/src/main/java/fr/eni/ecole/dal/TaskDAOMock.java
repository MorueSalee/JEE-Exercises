package fr.eni.ecole.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Task;

public class TaskDAOMock implements TaskDAO {
	private List<Task> taskList = new ArrayList<Task>();

	@Override
	public void insert(Task task) throws DalException, ClassNotFoundException {
		taskList.add(task);
	}

	@Override
	public List<Task> selectAll() throws DalException, ClassNotFoundException {
		List<Task> filteredTaskList = new ArrayList<Task>();
		for (Task task : taskList) {
			if (!task.getIsDone()) {
				filteredTaskList.add(task);
			}
		}	
		
		return filteredTaskList;
	}

	@Override
	public List<Task> selectAllNotDoneOrderedByPriority() throws DalException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
