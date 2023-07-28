package fr.formation.task.dal;

import java.util.List;

import fr.formation.task.bo.Task;

public interface TaskDAO {
	public void insert(Task task) throws DALException;
	public List<Task> getAll() throws DALException;
}
