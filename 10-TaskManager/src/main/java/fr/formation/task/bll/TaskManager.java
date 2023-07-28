package fr.formation.task.bll;

import java.util.List;

import fr.formation.task.bo.Task;

public interface TaskManager {
	public void addTask(Task task) throws TaskException;
	
	public List<Task> getAllTasksToDo() throws TaskException;
}
