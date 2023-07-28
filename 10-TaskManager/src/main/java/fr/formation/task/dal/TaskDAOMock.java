package fr.formation.task.dal;

import java.util.ArrayList;
import java.util.List;

import fr.formation.task.bo.Task;

public class TaskDAOMock implements TaskDAO {
	private List<Task> lst = new ArrayList<>();
	private static Integer cpt=0;
	@Override
	public void insert(Task task) {
		task.setIdTask(cpt++);
		lst.add(task);
	}

	@Override
	public List<Task> getAll() {
		return lst;
	}

}
